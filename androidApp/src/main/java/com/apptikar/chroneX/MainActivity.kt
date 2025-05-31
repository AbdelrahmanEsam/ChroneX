package com.apptikar.chroneX

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.apptikar.designSystem.ChroneXTheme
import com.apptikar.designSystem.headingFive
import com.apptikar.designSystem.inputs.ChroneDropDown


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChroneXTheme {
                val inputState = rememberTextFieldState()
                ChroneDropDown(
                    state = inputState,
                    options = listOf("1","2","3"),
                    placeHolder = "placeholder",
                    onValueChange = {},
                )
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(
        text = text, style = MaterialTheme.typography.headingFive
    )
}

@Preview
@Composable
fun DefaultPreview() {
    ChroneXTheme {
        GreetingView("Hello, Android!")
    }
}
