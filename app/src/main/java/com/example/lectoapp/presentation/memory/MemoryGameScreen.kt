package com.example.lectoapp.presentation.memory

import MemoryGameCard
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemoryGameScreen(
    pendingPairs: Int,
    gameCards: List<MemoryCard>,
    onMemoryCardTap: (Int) -> Unit,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                windowInsets = WindowInsets(
                    top = 0.dp,
                    bottom = 0.dp
                ),
                title = {
                    Text(text = "Memorama")
                },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = 16.dp,
                        end = 18.dp
                    ),
                horizontalArrangement = Arrangement.End
            ) {
                Text(text = "Pares restantes: $pendingPairs")
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
                onMemoryCardTap = {},
                onBackPressed = {}
            )
        }
    }
}