package com.apptikar.designSystem.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.apptikar.designSystem.ChroneXTheme
import com.chroneX.designSystem.R
import com.apptikar.designSystem.chroneXDarkTwo
import com.apptikar.designSystem.chroneXGray300
import com.apptikar.designSystem.chroneXGreen
import com.apptikar.designSystem.chroneXGreenBackground
import com.apptikar.designSystem.chroneXPrimaryColor
import com.apptikar.designSystem.chroneXWhite


@Composable
fun ChroneXButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    contentColor: Color = MaterialTheme.colorScheme.chroneXWhite,
    trailingComposable: @Composable (() -> Unit)? = null,
    leadingComposable: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(12.dp),
    contentPadding: PaddingValues = PaddingValues(
        horizontal = 24.dp,
        vertical = 16.dp
    )
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor,
            disabledContainerColor = backgroundColor.copy(alpha = 0.6f),
            disabledContentColor = contentColor.copy(alpha = 0.6f)
        ),
        contentPadding = contentPadding,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 2.dp,
            disabledElevation = 0.dp
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            leadingComposable?.let {
                leadingComposable.invoke()
                Spacer(modifier = Modifier.width(8.dp))
            }


            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Medium
                )
            )


            trailingComposable?.let {
                Spacer(modifier = Modifier.width(8.dp))
                trailingComposable.invoke()
            }
        }
    }

}


@Composable
private fun ChronePlusButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.chroneXGreen,
    contentColor: Color = MaterialTheme.colorScheme.chroneXWhite,
    size: Dp = 48.dp,
    iconSize: Dp = 12.dp,
    shape: Shape = CircleShape,
    enabled: Boolean = true,
    elevation: Dp = 0.dp,
    border: BorderStroke? = null
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(size),
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor,
            disabledContainerColor = backgroundColor.copy(alpha = 0.6f),
            disabledContentColor = contentColor.copy(alpha = 0.6f)
        ),
        contentPadding = PaddingValues(0.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = elevation,
            pressedElevation = if (elevation > 0.dp) elevation + 2.dp else 0.dp,
            disabledElevation = 0.dp
        ),
        border = border
    ) {

        AsyncImage(
            modifier = Modifier.size(iconSize),
            model = R.drawable.plus,
            colorFilter = ColorFilter.tint(contentColor),
            contentDescription = "Gradient background",
        )
    }
}

@Composable
fun ChroneBlackRoundedPlusButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 48.dp
) = ChronePlusButton(
    onClick = onClick,
    modifier = modifier,
    backgroundColor = MaterialTheme.colorScheme.chroneXDarkTwo,
    contentColor = MaterialTheme.colorScheme.chroneXWhite,
    size = size,
    shape = RoundedCornerShape(12.dp)
)

@Composable
fun ChroneTealCircle(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 48.dp
) = ChronePlusButton(
    onClick = onClick,
    modifier = modifier,
    backgroundColor = MaterialTheme.colorScheme.chroneXPrimaryColor,
    contentColor = MaterialTheme.colorScheme.chroneXWhite,
    size = size,
    shape = CircleShape
)


@Composable
fun ChroneOutlinedGreen(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 48.dp
) = ChronePlusButton(
    onClick = onClick,
    modifier = modifier,
    backgroundColor = Color.Transparent,
    contentColor = MaterialTheme.colorScheme.chroneXPrimaryColor,
    size = size,
    shape = RoundedCornerShape(12.dp),
    border = BorderStroke(1.dp, MaterialTheme.colorScheme.chroneXGray300)
)

@Preview
@Composable
private fun TealCirclePreview() {
    ChroneXTheme {
        ChroneBlackRoundedPlusButton(
            modifier = Modifier.padding(20.dp),
            onClick = { /*TODO*/ },
        )
    }
}

@Preview
@Composable
private fun TealCircleDisabledPreview() {
    ChroneXTheme {
        Spacer(Modifier.size(100.dp))
        ChroneOutlinedGreen(
            onClick = { /*TODO*/ },
        )
    }
}




@Preview
@Composable
private fun ChroneXButtonPreview() {
    ChroneXTheme {
        ChroneXButton(
            text = "Button",
            onClick = { /*TODO*/ },
            backgroundColor = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview
@Composable
private fun ChroneXButtonWithLeadingIconPreview() {
    ChroneXTheme {
        ChroneXButton(
            text = "Button",
            onClick = { /*TODO*/ },
            backgroundColor = MaterialTheme.colorScheme.chroneXPrimaryColor,
        )
    }
}

@Preview
@Composable
private fun ChroneXButtonWithTrailingIconPreview() {
    ChroneXTheme {
        ChroneXButton(
            text = "Button",
            onClick = { /*TODO*/ },
            backgroundColor = MaterialTheme.colorScheme.chroneXPrimaryColor,
        )
    }
}

@Preview
@Composable
private fun ChroneXButtonDisabledPreview() {
    ChroneXTheme {
        ChroneXButton(
            text = "Button",
            onClick = { /*TODO*/ },
            backgroundColor = MaterialTheme.colorScheme.chroneXGreenBackground,
            contentColor = MaterialTheme.colorScheme.chroneXPrimaryColor,
            shape = RoundedCornerShape(100.dp),
            enabled = false
        )
    }
}