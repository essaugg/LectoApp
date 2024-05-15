package com.example.lectoapp.ui.initial_test

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lectoapp.R

@Composable
fun SoundQuestion(
    modifier: Modifier = Modifier,
    question: TestQuestion,
    onAnswer: (TestOption) -> Unit,
    onContinue:() -> Unit
) {

    val viewModel: TestViewModel.ProgressBarViewModel = viewModel()
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
            Box(
                modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp)
            ) {
                IconButton(
                    onClick = {
                    },
                    content = {
                        Icon(
                            modifier = Modifier
                                .size(40.dp),
                            painter = painterResource(id = R.drawable.btn_back),
                            contentDescription = ""
                        )
                    }
                )
            }
        },

        bottomBar = {
            if (question.answer != null ) {
                Button(
                    onClick = {
                        onContinue()
                        viewModel.incrementProgress()
                    },
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
                        .size(width = 150.dp, height = 40.dp),
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

                ProgressBar()

                Spacer(modifier = Modifier.height(15.dp))

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

                Spacer(modifier = Modifier.height(40.dp))

                IconButton(
                    onClick = {
                    },
                    content = {
                        Icon(
                            modifier = Modifier
                                .size(100.dp),

                            painter = painterResource(id = R.drawable.ic_speaker),
                            contentDescription = ""
                        )


                    }
                )

                Text(
                    text = "¿Que letra escuchas?",
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 32.dp, end = 32.dp)
                        .align(Alignment.CenterHorizontally)
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
private fun SoundQuestionPreview() {

    MaterialTheme {
        Surface {
            SoundQuestion(
                modifier = Modifier.fillMaxSize(),
                question = TestQuestion(
                    resId = R.raw.alphabet_e,
                    text = "",
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
                    ),
                    questionType = QuestionType.Sound
                ),
                onAnswer = {},
                onContinue = {}
            )
        }
    }
}