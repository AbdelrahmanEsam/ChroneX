package com.apptikar.designSystem.tags

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apptikar.designSystem.chroneXErrorColor
import com.apptikar.designSystem.chroneXPrimaryColor
import com.apptikar.designSystem.chroneXWarningColor
import com.apptikar.designSystem.chroneXWhite


@Composable
fun ChroneFilledTagMarker(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    backgroundColor: Color = MaterialTheme.colorScheme.chroneXPrimaryColor,
    contentColor: Color = MaterialTheme.colorScheme.chroneXWhite,
    onClick: () -> Unit = {},
) {
    Surface(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(6.dp),
        color = backgroundColor,
        contentColor = contentColor
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 12.dp,
                vertical = 6.dp
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                color = contentColor
            )
        }
    }
}


@Composable
fun ChroneOutlinedTagMarker(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    borderColor: Color = MaterialTheme.colorScheme.chroneXPrimaryColor,
    contentColor: Color = borderColor,
    onClick: () -> Unit = {},
) {
    Surface(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(1.dp, borderColor),
        contentColor = contentColor
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 12.dp,
                vertical = 6.dp
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                color = contentColor
            )
        }
    }
}


@Preview
@Composable
fun ChroneTagMarkerPreview() {
    ChroneFilledTagMarker(
        text = "Android",
    )
}

@Preview
@Composable
fun ChroneTagMarkerDisabledPreview() {
    ChroneOutlinedTagMarker(
        text = "Android",
        enabled = false
    )
}

@Preview
@Composable
fun ChroneTagMarkerCustomColorsPreview() {
    ChroneFilledTagMarker(text = "Android", backgroundColor = Color.Red, contentColor = Color.Blue)
}
