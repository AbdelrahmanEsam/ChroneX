package com.apptikar.designSystem.radio

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.apptikar.designSystem.chroneXPrimaryColor


@Composable
fun CustomRadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String? = null,
    enabled: Boolean = true,
    color: Color = MaterialTheme.colorScheme.chroneXPrimaryColor,
    innerDotColor: Color = MaterialTheme.colorScheme.chroneXPrimaryColor,
    textColor: Color = Color.Black,
    size: Dp = 24.dp,
    borderWidth: Dp = 2.dp,
    innerDotSize: Dp = 14.dp,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    spacing: Dp = 12.dp
) {
    Row(
        modifier = modifier
            .clickable(
                enabled = enabled,
            ) {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .border(
                    width = borderWidth,
                    color = color,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            this@Row.AnimatedVisibility(
                visible = selected,
                enter = scaleIn(
                    animationSpec = tween(150),
                    initialScale = 0.3f
                ) + fadeIn(tween(150)),
                exit = scaleOut(
                    animationSpec = tween(150),
                    targetScale = 0.3f
                ) + fadeOut(tween(150))
            ) {
                Box(
                    modifier = Modifier
                        .size(innerDotSize)
                        .background(
                            color = innerDotColor,
                            shape = CircleShape
                        )
                )
            }
        }

        text?.let {
            Spacer(modifier = Modifier.width(spacing))
            Text(
                text = it,
                style = textStyle,
                color =  textColor
            )
        }
    }
}

@Preview
@Composable
private fun RadioButtonUnchecked() {
    CustomRadioButton(selected = false, onClick = { /*TODO*/ })
}


@Preview
@Composable
private fun RadioButtonChecked() {
    CustomRadioButton(selected = true, onClick = { /*TODO*/ },text = "radio Button")
}



