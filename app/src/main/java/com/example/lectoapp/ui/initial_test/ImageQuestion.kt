package com.example.lectoapp.ui.initial_test

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lectoapp.R

@Composable
fun ImageQuestion(
    modifier: Modifier = Modifier,
    question: TestQuestion.Image
) {
    val grayScaleMatrix = ColorMatrix(
        floatArrayOf(
            0.33f, 0.33f, 0.33f, 0f, 0f,
            0.33f, 0.33f, 0.33f, 0f, 0f,
            0.33f, 0.33f, 0.33f, 0f, 0f,
            0f, 0f, 0f, 1f, 0f
        )
    )

    Scaffold(
        modifier = modifier,
        topBar = {
            Text(
                modifier = Modifier.padding(16.dp),
                text = question.text,
                style = MaterialTheme.typography.h6
            )
        },
        bottomBar = {
            if (question.answer != null) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Siguiente")
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            IconButton(
                onClick = {

                },
                content = {
                    Image(
                        modifier = Modifier.size(108.dp),
                        painter = painterResource(id = question.resId),
                        contentDescription = ""
                    )
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            question.options.forEach { option ->
                Image(
                    modifier = Modifier.size(120.dp),
                    painter = painterResource(id = option.resId),
                    contentDescription = "",
                    colorFilter = if (option.id == question.answer?.id) null
                    else ColorFilter.colorMatrix(grayScaleMatrix)
                )
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Preview
@Composable
private fun ImageQuestionPreview() {
    MaterialTheme {
        Surface {
            ImageQuestion(
                modifier = Modifier.fillMaxSize(),
                question = TestQuestion.Image(
                    resId = R.drawable.a,
                    text = "¿Que letra(numero) es este?",
                    options = listOf(
                        TestOption(
                            id = "a",
                            optionText = "",
                            resId = R.drawable.a
                        ),
                        TestOption(
                            id = "e",
                            optionText = "",
                            resId = R.drawable.e
                        ),
                        TestOption(
                            id = "i",
                            optionText = "",
                            resId = R.drawable.i
                        )
                    )
                )
            )
        }
    }
}