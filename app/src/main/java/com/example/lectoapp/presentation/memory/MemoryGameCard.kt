import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.lectoapp.R
import com.example.lectoapp.presentation.memory.MemoryCard

@Composable
fun MemoryGameCard(
    modifier: Modifier = Modifier,
    memoryCard: MemoryCard,
    onTap: (MemoryCard) -> Unit
) {
    val transition = updateTransition(targetState = memoryCard.isFaceUp)
    val interactionSource = remember { MutableInteractionSource() }

    val animatedRotationY by transition.animateFloat(
        transitionSpec = {
            if (memoryCard.isFaceUp) {
                keyframes {
                    durationMillis = 500 //tiempo
                    0f at 0
                    180f at 150
                }
            } else {
                keyframes {
                    durationMillis = 500 //tiempo
                    180f at 0
                    0f at 150
                }
            }
        },
        label = "rotationYAnimation"
    ) { state ->
        if (state) 180f else 0f
    }

    Image(
        modifier = modifier

            .size(64.dp)
            .clickable(
                indication = null,
                interactionSource = interactionSource
            ) { onTap(memoryCard) }
            .graphicsLayer {
                // Voltear imagen
                scaleX = if (memoryCard.isFaceUp) -1f else 1f
                rotationY = animatedRotationY
            },
        painter = painterResource(id = if (memoryCard.isFaceUp) memoryCard.drawResId else R.drawable.fondo),
        contentDescription = "",
        contentScale = ContentScale.Fit

    )
}

class MemoryGameCardPreviewParamProvider : PreviewParameterProvider<MemoryCard> {
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
                memoryCard = memoryCard,
                onTap = {}


            )
        }
    }
}


