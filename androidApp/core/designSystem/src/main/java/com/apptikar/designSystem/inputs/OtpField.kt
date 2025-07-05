package com.apptikar.designSystem.inputs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.semantics.contentType
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apptikar.designSystem.ChroneXTheme
import com.apptikar.designSystem.chroneXGray50
import com.apptikar.designSystem.chroneXGray900
import com.apptikar.designSystem.chroneXGreenBackground
import com.apptikar.designSystem.chroneXPrimaryColor
import com.apptikar.designSystem.headingFour

@Composable
fun ChroneXOtpField(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    limitedLines: TextFieldLineLimits = TextFieldLineLimits.SingleLine,
    inputType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    keyboardOptions: KeyboardOptions? = null,
    trailingComposable: @Composable (() -> Unit)? = null,
    leadingComposable: @Composable (() -> Unit)? = null,
    onValidate: () -> Unit = {},
    numberOfOtpFields: Int = 4
) {
    val keyboardState = rememberKeyboardAsState()
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }
    val grayBackground = MaterialTheme.colorScheme.chroneXGray50
    val borderColor = MaterialTheme.colorScheme.chroneXPrimaryColor
    val greenBackground = MaterialTheme.colorScheme.chroneXGreenBackground

    BasicTextField(
        modifier = modifier
            .semantics {
                contentType = ContentType.SmsOtpCode
            }
            .clip(RoundedCornerShape(16.dp))
            .focusRequester(focusRequester),
        state = state,
        inputTransformation = InputTransformation.maxLength(numberOfOtpFields),
        outputTransformation = {},
        keyboardOptions = keyboardOptions ?: KeyboardOptions(
            keyboardType = inputType,
            imeAction = imeAction
        ),
        onKeyboardAction = { performDefaultAction ->
            if (numberOfOtpFields == state.text.length) {
                keyboardController?.hide()
            }
            onValidate()
            performDefaultAction()
        },
        decorator = { _ ->
            val otpCode = state.text.toString()
            leadingComposable?.invoke()
            Spacer(modifier = Modifier.size(15.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(numberOfOtpFields) {
                    Digit(
                        number = otpCode.getOrElse(it, defaultValue = { ' ' }),
                        borderColor = borderColor,
                        focusedBackgroundColor = greenBackground,
                        unfocusedBackgroundColor = grayBackground,
                        isFocused = it == state.text.length && keyboardState.value
                    )
                }
            }
            Spacer(modifier = Modifier.size(15.dp))
            trailingComposable?.invoke()
        },
        lineLimits = limitedLines,
    )
}

@Composable
fun Digit(
    modifier: Modifier = Modifier,
    number: Char,
    borderColor: Color,
    focusedBackgroundColor: Color,
    unfocusedBackgroundColor: Color,
    isFocused: Boolean,
) {
    Box(
        modifier
            .width(80.dp)
            .height(70.dp)
            .drawBehind {
                drawRoundRect(
                    color = if (isFocused) focusedBackgroundColor else unfocusedBackgroundColor,
                    cornerRadius = CornerRadius(16.dp.toPx()),
                )
                drawRoundRect(
                    color = borderColor,
                    style = Stroke(width = 2.dp.toPx()),
                    cornerRadius = CornerRadius(16.dp.toPx()),
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = number.toString(),
            style = MaterialTheme.typography.headingFour.copy(MaterialTheme.colorScheme.chroneXGray900)
        )
    }
}


@Composable
fun rememberKeyboardAsState(): State<Boolean> {
    val isImeVisible = WindowInsets.ime.getBottom(LocalDensity.current) > 0
    return rememberUpdatedState(isImeVisible)
}


@Preview(showBackground = true)
@Composable
private fun OtpChroneInputFieldPreview() {
    ChroneXTheme {
        ChroneXOtpField(
            state = rememberTextFieldState(""),
        )
    }
}