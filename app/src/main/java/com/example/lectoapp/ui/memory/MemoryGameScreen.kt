package com.example.lectoapp.ui.memory

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MemoryGameScreen(
    pendingPairs: Int,
    gameCards: List<MemoryCard>,
    onMemoryCardTap: (Int) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Juego de memoria"
            )
            Text(text = "Restantes $pendingPairs")
        }
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            columns = GridCells.Fixed(count = 2)
        ) {
            items(gameCards) {
                MemoryGameCard(
                    modifier = Modifier
                        .size(180.dp)
                        .padding(8.dp),
                    memoryCard = it,
                    onTap = { tappedCard ->
                        val indexOfSelection = gameCards.map { gameCard ->
                            gameCard.cardId
                        }.indexOf(tappedCard.cardId)
                        onMemoryCardTap(indexOfSelection)
                    }
                )
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
private fun MemoryGameScreenPreview() {
    MaterialTheme {
        Surface {
            MemoryGameScreen(
                pendingPairs = 4,
                gameCards = GameConfig.cards + GameConfig.cards,
                onMemoryCardTap = {}
            )
        }
    }
}