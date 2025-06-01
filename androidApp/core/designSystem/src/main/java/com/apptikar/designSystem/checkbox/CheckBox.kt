package com.apptikar.designSystem.checkbox

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.apptikar.designSystem.ChroneXTheme
import com.apptikar.designSystem.R
import com.apptikar.designSystem.chroneXBlack
import com.apptikar.designSystem.chroneXPrimaryColor
import com.apptikar.designSystem.chroneXWhite


@Composable
fun ChroneCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    text: String? = null,
    enabled: Boolean = true,
    checkedColor: Color = MaterialTheme.colorScheme.chroneXPrimaryColor, // Green from your image
    checkmarkColor: Color = MaterialTheme.colorScheme.chroneXWhite,
    textColor: Color = MaterialTheme.colorScheme.chroneXBlack,
    size: Dp = 24.dp,
    cornerRadius: Dp = 6.dp,
    borderWidth: Dp = 2.dp,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    spacing: Dp = 12.dp
) {
    Row(
        modifier = modifier
            .clickable(
                enabled = enabled,
            ) {
                onCheckedChange(!checked)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .background(
                    color = if (checked) checkedColor else Color.Transparent,
                    shape = RoundedCornerShape(cornerRadius)
                )
                .border(
                    width = borderWidth,
                    color = checkedColor,
                    shape = RoundedCornerShape(cornerRadius)
                ),
            contentAlignment = Alignment.Center
        ) {
            this@Row.AnimatedVisibility(
                visible = checked,
                enter = scaleIn(tween(150)) + fadeIn(tween(150)),
                exit = scaleOut(tween(150)) + fadeOut(tween(150))
            ) {
                AsyncImage(
                    modifier = Modifier.size(12.dp),
                    model = R.drawable.check,
                    colorFilter = ColorFilter.tint(color = checkmarkColor),
                    contentDescription = "Gradient background",
                )
            }
        }

        text?.let {
            Spacer(modifier = Modifier.width(spacing))
            Text(
                text = it,
                style = textStyle,
                color = if (enabled) textColor else textColor.copy(alpha = 0.6f)
            )
        }
    }
}

@Preview("Dark Theme")
@Composable
fun ChroneCheckboxPreviewDark() {
    ChroneXTheme {
        ChroneCheckbox(
            checked = true,
            onCheckedChange = {},
            text = "Remember me"
        )
    }
}

@Preview("Light Theme")
@Composable
fun ChroneCheckboxPreviewLight() {
    ChroneXTheme {
        ChroneCheckbox(
            checked = false,
            onCheckedChange = {},
            text = "Remember me"
        )
    }
}
