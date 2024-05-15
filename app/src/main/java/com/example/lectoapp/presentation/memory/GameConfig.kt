package com.example.lectoapp.presentation.memory

import com.example.lectoapp.R
import java.util.UUID

object GameConfig {
    val cards = listOf(
        MemoryCard(
            pairId = "1",
            drawResId = R.drawable.a,
            isFaceUp = false,
            isMatched = false
        ),
        MemoryCard(
            pairId = "2",
            drawResId = R.drawable.e,
            isFaceUp = false,
            isMatched = false
        ),
        MemoryCard(
            pairId = "3",
            drawResId = R.drawable.i,
            isFaceUp = false,
            isMatched = false
        ),
        MemoryCard(
            pairId = "4",
            drawResId = R.drawable.o,
            isFaceUp = false,
            isMatched = false
        ),
    )
}

fun List<MemoryCard>.createGameFromCards(): List<MemoryCard> {
    val secondHand = this.map {
        it.copy(
            cardId = UUID.randomUUID().toString()
        )
    }
    return this + secondHand
}