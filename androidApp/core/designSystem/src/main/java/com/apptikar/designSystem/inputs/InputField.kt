package com.apptikar.designSystem.inputs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apptikar.designSystem.BodyLarge
import com.apptikar.designSystem.ChroneXTheme
import com.apptikar.designSystem.chroneXGray50
import com.apptikar.designSystem.chroneXGray500
import com.apptikar.designSystem.chroneXGreen
import com.apptikar.designSystem.chroneXGreenBackground
import com.apptikar.designSystem.chroneXPrimaryColor


@Composable
fun ChroneInputField(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    placeHolder: String? = null,
    limitedLines: TextFieldLineLimits = TextFieldLineLimits.SingleLine,
    inputType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    keyboardOptions: KeyboardOptions? = null,
    trailingComposable: @Composable (() -> Unit)? = null,
    leadingComposable: @Composable (() -> Unit)? = null,
    onValidate: () -> Unit = {},
    readOnly: Boolean = false
) {
    val focusRequester = remember { FocusRequester() }
    val grayBackground = MaterialTheme.colorScheme.chroneXGray50
    val borderColor = MaterialTheme.colorScheme.chroneXPrimaryColor
    val greenBackground = MaterialTheme.colorScheme.chroneXGreenBackground

    TextField(
        modifier = modifier
            .then(
                if (state.text.isNotBlank())
                    Modifier
                        .padding(2.dp)
                        .drawBehind {
                            drawRoundRect(
                                color = borderColor,
                                style = Stroke(width = 2.dp.toPx()),
                                cornerRadius = CornerRadius(16.dp.toPx()),
                            )
                        } else Modifier
            )
            .clip(RoundedCornerShape(16.dp))
            .focusRequester(focusRequester),
        state = state,
        inputTransformation = InputTransformation { },
        placeholder = {
            if (placeHolder != null) Text(
                placeHolder,
                style = MaterialTheme.typography.BodyLarge.copy(color = MaterialTheme.colorScheme.chroneXGreen)
            ) else null
        },
        outputTransformation = {},
        keyboardOptions = keyboardOptions ?: KeyboardOptions(
            keyboardType = inputType,
            imeAction = imeAction
        ),
        onKeyboardAction = { performDefaultAction ->
            onValidate()
            performDefaultAction()
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedContainerColor = if (state.text.isBlank()) {
                grayBackground
            } else {
                greenBackground
            },
            unfocusedContainerColor = if (state.text.isBlank()) grayBackground else greenBackground
        ),
        lineLimits = limitedLines,
        leadingIcon = leadingComposable,
        trailingIcon = trailingComposable,
        readOnly = readOnly
    )

}


@Composable
fun ChroneFormInputField(
    title: String,
    placeholder: String,
    state: TextFieldState,
    trailingComposable: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val underlineColor = MaterialTheme.colorScheme.chroneXPrimaryColor
    val placeholderColor = MaterialTheme.colorScheme.chroneXGray500
    val focusRequester = remember { FocusRequester() }

    Column(
        modifier = modifier.fillMaxWidth().clickable{
            focusRequester.requestFocus()
        }
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        TextField(
            state = state,
            placeholder = {
                Text(
                    text = placeholder,
                    color = placeholderColor,
                    style = MaterialTheme.typography.bodyLarge
                )
            },
            trailingIcon = trailingComposable,
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedIndicatorColor = underlineColor,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = underlineColor
            ),
            textStyle = MaterialTheme.typography.bodyLarge,
            lineLimits = TextFieldLineLimits.SingleLine,
            modifier = Modifier.fillMaxWidth().focusRequester(focusRequester)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ChroneFormInputFieldPreview() {
    ChroneXTheme {
        ChroneFormInputField(
            title = "Title",
            placeholder = "Placeholder",
            state = rememberTextFieldState("hello")
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChroneInputFieldPreview() {
    ChroneXTheme {
        ChroneInputField(
            state = rememberTextFieldState("hello"),
            limitedLines = TextFieldLineLimits.SingleLine
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChroneInputFieldPreviewMultiLine() {
    ChroneXTheme {
        ChroneInputField(
            state = rememberTextFieldState("hello"),
            limitedLines = TextFieldLineLimits.MultiLine(maxHeightInLines = 5)
        )
    }
}

