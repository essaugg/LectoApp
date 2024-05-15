package com.example.lectoapp.ui.initial_test

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lectoapp.R
import com.example.lectoapp.data.InitialQuestion

@Composable
fun WordQuestion(
    modifier: Modifier = Modifier,
    question: TestQuestion,
    onAnswer: (TestOption) -> Unit,
    onContinue:() -> Unit
) {
    //ProgressBar
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
                    }
                ) {
                    Text(text = "Siguiente")
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
                Spacer(modifier = Modifier.height(20.dp))

                Image(
                    modifier = Modifier
                        .size(145.dp),
                    painter = painterResource(id = question.resId),
                    contentDescription = "",

                    )

                Spacer(modifier = Modifier.height(20.dp))

                question.options.forEach { option ->
                    Image(
                        modifier = Modifier
                            .size(130.dp)
                            .clickable {
                                onAnswer(option)
                            },
                        painter = painterResource(id = option.resId),
                        contentDescription = "",
                        colorFilter = if (option.id == question.answer?.id) null
                        else ColorFilter.colorMatrix(grayScaleMatrix)
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                }
            }
        }
    )

}

@Preview
@Composable
private fun WordQuestionPreview() {
    MaterialTheme {
        Surface {
            WordQuestion(
                modifier = Modifier.fillMaxSize(),
                question = TestQuestion(
                    resId = R.drawable.pelota,
                    text = "¿Que letra completa la palabra?",
                    options = listOf(
                        TestOption(
                            id = "o",
                            optionText = "",
                            resId = R.drawable.img_o
                        ),
                        TestOption(
                            id = "a",
                            optionText = "",
                            resId = R.drawable.img_a
                        ),
                        TestOption(
                            id = "i",
                            optionText = "",
                            resId = R.drawable.img_i
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

