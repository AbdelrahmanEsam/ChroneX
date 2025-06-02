package com.apptikar.designSystem.chips

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.apptikar.designSystem.ChroneXTheme
import com.chroneX.designSystem.R
import com.apptikar.designSystem.chroneXPrimaryColor
import com.apptikar.designSystem.chroneXWhite


@Composable
fun ChroneFilledChip(
    text: String,
    onClick: () -> Unit = {},
    backgroundColor: Color = MaterialTheme.colorScheme.chroneXPrimaryColor,
    contentColor: Color = MaterialTheme.colorScheme.chroneXWhite,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {

    Surface(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(50),
        color = backgroundColor,
        contentColor = contentColor
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            leadingIcon?.let { icon ->
                icon()
                Spacer(modifier = Modifier.width(8.dp))
            }

            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Medium
            )

            trailingIcon?.let { icon ->
                Spacer(modifier = Modifier.width(8.dp))
                icon()
            }
        }
    }
}

@Composable
fun OutlinedFilledChip(
    text: String,
    onClick: () -> Unit = {},
    borderColor: Color = MaterialTheme.colorScheme.chroneXPrimaryColor,
    contentColor: Color = MaterialTheme.colorScheme.chroneXPrimaryColor,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {

    Surface(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(50),
        color = Color.Transparent,
        border = BorderStroke(1.dp, borderColor),
        contentColor = contentColor
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            leadingIcon?.let { icon ->
                icon()
                Spacer(modifier = Modifier.width(8.dp))
            }

            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Medium
            )

            trailingIcon?.let { icon ->
                Spacer(modifier = Modifier.width(8.dp))
                icon()
            }
        }
    }
}

@Preview
@Composable
fun ChroneFilledChipPreview() {
    ChroneXTheme {
        ChroneFilledChip(
            text = "Filled Chip"
        )
    }
}

@Preview
@Composable
fun ChroneFilledChipWithLeadingIconPreview() {
    ChroneXTheme {
        ChroneFilledChip(
            text = "Filled Chip",
            leadingIcon = {
                AsyncImage(
                    modifier = Modifier.size(20.dp),
                    model = R.drawable.warning,
                    colorFilter = ColorFilter.tint(Color.Blue),
                    contentDescription = "Gradient background",
                )
            },
            trailingIcon = {
                AsyncImage(
                    modifier = Modifier.size(20.dp),
                    model = R.drawable.warning,
                    colorFilter = ColorFilter.tint(Color.Blue),
                    contentDescription = "Gradient background",
                )
            }
        )
    }
}

@Preview
@Composable
fun ChroneFilledChipWithTrailingIconPreview() {
    ChroneXTheme {
        ChroneFilledChip(
            text = "Filled Chip",
            trailingIcon = {

            }
        )
    }
}

@Preview
@Composable
fun ChroneFilledChipDisabledPreview() {
    ChroneXTheme { OutlinedFilledChip(text = "Filled Chip", enabled = false) }
}