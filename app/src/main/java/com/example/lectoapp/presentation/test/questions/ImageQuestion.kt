package com.example.lectoapp.presentation.test.questions

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lectoapp.R


@Composable
fun ImageQuestion(
    modifier: Modifier = Modifier,
    question: TestQuestion,
    onAnswer: (TestOption) -> Unit,
    onContinue:() -> Unit
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
        bottomBar = {
            if (question.answer != null ) {
                Button(
                    onClick = {
                        onContinue()
                    },
                    modifier = Modifier
                        .padding(start = 32.dp),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Text(
                        text = "Siguiente",
                        fontSize = 20.sp,
                    )
                }
            }
        },

        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = question.text,
                    fontSize = 30.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 32.dp)
                        .align(Alignment.Start)
                )

                Text(
                    text = "Selecciona la respuesta correcta",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 32.dp)
                        .align(Alignment.Start)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Image(
                    modifier = Modifier
                        .size(145.dp),
                    painter = painterResource(id = question.resId),
                    contentDescription = "",
                )

                Text(
                    text = "¿Que respuesta coincide con la imagen?",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 32.dp, end = 32.dp)
                        .align(Alignment.Start)
                )

                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.spacedBy(8.dp), // Espacio entre las imágenes
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    question.options.take(2).forEach { option ->
                        Image(
                            modifier = Modifier
                                .size(160.dp)
                                .clickable {
                                    onAnswer(option)
                                },
                            painter = painterResource(id = option.resId),
                            contentDescription = "",
                            colorFilter = if (option.id == question.answer?.id) null
                            else ColorFilter.colorMatrix(grayScaleMatrix)
                        )
                    }
                }
                //
                Spacer(modifier = Modifier.height(20.dp))


                question.options.getOrNull(2)?.let { option ->
                    Image(
                        modifier = Modifier
                            .size(160.dp)
                            .clickable {
                                onAnswer(option)
                            },
                        painter = painterResource(id = option.resId),
                        contentDescription = "",
                        colorFilter = if (option.id == question.answer?.id) null
                        else ColorFilter.colorMatrix(grayScaleMatrix)
                    )
                }

            }
        }
    )

}

@Preview
@Composable
private fun ImageQuestionPreview() {
    MaterialTheme {
        Surface {
            ImageQuestion(
                modifier = Modifier.fillMaxSize(),
                question = TestQuestion(
                    resId = R.drawable.img_tres,
                    text = "",
                    options = listOf(
                        TestOption(
                            id = "cuatro",
                            optionText = "",
                            resId = R.drawable.cuatro
                        ),
                        TestOption(
                            id = "tres",
                            optionText = "",
                            resId = R.drawable.tres
                        ),
                        TestOption(
                            id = "dos",
                            optionText = "",
                            resId = R.drawable.dos
                        )
                    ),
                    questionType = QuestionType.Image
                ),
                onAnswer = {},
                onContinue = {}
            )
        }
    }
}