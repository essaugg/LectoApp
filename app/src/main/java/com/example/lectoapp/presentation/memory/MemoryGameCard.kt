package com.example.lectoapp.presentation.memory

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.lectoapp.R

@Composable
fun MemoryGameCard(
    modifier: Modifier = Modifier,
    memoryCard: MemoryCard,
    onTap: (MemoryCard) -> Unit
) {
    Image(
        modifier = modifier
            .clickable { onTap(memoryCard) },
        painter =  painterResource(id = if (memoryCard.isFaceUp) memoryCard.drawResId else R.drawable.ic_launcher_background),
        contentDescription = "",
        contentScale = ContentScale.Fit
    )
}

class MemoryGameCardPreviewParamProvider: PreviewParameterProvider<MemoryCard> {
    override val values: Sequence<MemoryCard>
        get() = sequenceOf(
            MemoryCard(
                pairId = "1",
                drawResId = R.drawable.a,
                isFaceUp = false,
                isMatched = false
            ),
            MemoryCard(
                pairId = "2",
                drawResId = R.drawable.a,
                isFaceUp = true,
                isMatched = false
            )
        )
}

@Preview
@Composable
private fun MemoryGameCardPreview(
    @PreviewParameter(MemoryGameCardPreviewParamProvider::class) memoryCard: MemoryCard
) {
    MaterialTheme {
        Surface {
            MemoryGameCard(
                modifier = Modifier.size(64.dp),
                memoryCard = memoryCard,
                onTap = {}
            )
        }
    }
}