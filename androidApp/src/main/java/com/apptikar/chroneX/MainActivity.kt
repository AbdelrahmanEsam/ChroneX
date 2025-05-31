package com.apptikar.chroneX

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.apptikar.designSystem.ChroneXTheme
import com.apptikar.designSystem.headingFive
import com.apptikar.designSystem.inputs.ChroneInputField
import com.apptikar.designSystem.inputs.ChroneOtpField


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChroneXTheme {
                val inputState = rememberTextFieldState()
                ChroneOtpField(state = inputState,)
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
