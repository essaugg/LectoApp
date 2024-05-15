package com.example.lectoapp.presentation.memory

import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class MemoryGameViewModel @Inject constructor(

) : ViewModel() {

    val gameCards = mutableStateListOf<MemoryCard>().apply {
        addAll((GameConfig.cards.createGameFromCards()).shuffled())
    }
    val pendingPairs = mutableIntStateOf(gameCards.size/2)

    private var indexOfSelectedCard: Int? = null


    private val gameEventsChannel = Channel<MemoryGameEvent>()
    val gameEventChannelFlow = gameEventsChannel.receiveAsFlow()

    fun updateGameByFlip(position: Int) {
        val item = gameCards[position]
        if (item.isFaceUp) return

        var matchFound = false

        // Three cases
        // 0 cards previously flipped over => restore cards + flip over the selected card
        // 1 card previously flipped over => flip over the selected card + check if the images match
        // 2 cards previously flipped over => restore cards + flip over the selected card
        if (indexOfSelectedCard == null) {
            restoreCards()
            indexOfSelectedCard = position
        } else {
            matchFound = isCorrectPair(indexOfSelectedCard!!, position)
            indexOfSelectedCard = null
        }
        val isSelected = item.isFaceUp
        gameCards[position] = item.copy(
            isFaceUp = !isSelected
        )
    }

    private fun isCorrectPair(position1: Int, position2: Int): Boolean {
        if (gameCards[position1].pairId != gameCards[position2].pairId) {
            return false
        }
        gameCards[position1].isMatched = true
        gameCards[position2].isMatched = true
        pendingPairs.intValue -= 1

        if (pendingPairs.intValue == 0) {
            viewModelScope.launch {
                gameEventsChannel.send(MemoryGameEvent.GameFinished)
            }
        }
        return true
    }

    /**
     *  Turn all unmatched cards face down
     */
    private fun restoreCards() {
        for (card in gameCards) {
            if (!card.isMatched) {
                card.isFaceUp = false
            }
        }
    }
}

sealed class MemoryGameEvent {
    data object GameFinished: MemoryGameEvent()
}

data class MemoryCard(
    val pairId: String,
    val cardId: String = UUID.randomUUID().toString(),
    @DrawableRes val drawResId: Int,
    var isFaceUp: Boolean,
    var isMatched: Boolean
)