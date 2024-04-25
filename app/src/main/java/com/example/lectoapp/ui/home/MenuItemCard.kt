package com.example.lectoapp.ui.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.lectoapp.R

@Composable
fun MenuItemCard(
    modifier: Modifier = Modifier,
    text: String,
    @DrawableRes resId: Int,
    onClick: () -> Unit,
) {

    var sizeImage by remember { mutableStateOf(IntSize.Zero) }

    val brush = Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color.Black),
        startY = sizeImage.height.toFloat()/3,
        endY = sizeImage.height.toFloat()
    )

    Box(modifier = modifier
        .clip(RoundedCornerShape(32.dp))
        .clickable { onClick() }){
        Image(
            painter = painterResource(id = resId),
            contentDescription = "",
            modifier = Modifier
                .matchParentSize()
                .onGloballyPositioned {
                    sizeImage = it.size
                },
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier
            .matchParentSize()
            .background(brush = brush))
        Text(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            text = text,
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.onPrimary
        )
    }
}

@Preview
@Composable
private fun MenuItemCardPreview() {
    MaterialTheme {
        Surface {
            MenuItemCard(
                modifier = Modifier.fillMaxSize(),
                text = "Menu item",
                resId = R.drawable.menu_image_memory,
                onClick = {}
            )
        }
    }
}