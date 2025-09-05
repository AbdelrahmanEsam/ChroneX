package com.apptikar.designSystem.bars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.apptikar.designSystem.ChroneXTheme
import com.apptikar.designSystem.chips.OutlinedFilledChip
import com.apptikar.designSystem.chroneXBlack
import com.apptikar.designSystem.chroneXWhite
import com.apptikar.designSystem.headingFour
import com.chroneX.designSystem.R

@Composable
fun ChroneHeader(
    title: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.chroneXWhite,
    titleColor: Color = MaterialTheme.colorScheme.chroneXBlack,
    elevation: Dp = 0.dp,
    trailingComposable: @Composable (() -> Unit)? = null,
    leadingComposable: @Composable (() -> Unit)? = null,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = backgroundColor,
        shadowElevation = elevation
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {

                trailingComposable?.invoke()

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = title,
                    style = MaterialTheme.typography.headingFour,
                    color = titleColor
                )

                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.size(40.dp)
                ) {
                    AsyncImage(
                        modifier = Modifier.size(20.dp),
                        model = R.drawable.back,
                        contentDescription = "Gradient background",
                    )
                }
            }






            leadingComposable?.invoke()
        }
    }
}


@Preview
@Composable
private fun HeaderWithLogoPreview() {
    ChroneXTheme {
        ChroneHeader(
            title = "Title",
            onBackClick = { /*TODO*/ },
            trailingComposable = {
                AsyncImage(
                    modifier = Modifier.size(30.dp),
                    model = R.drawable.logo,
                    contentDescription = "Gradient background",
                )
            },
            leadingComposable = {
                OutlinedFilledChip(
                    modifier = Modifier.height(50.dp),
                    text = "create",
                    onClick = {},
                    leadingIcon = {
                        AsyncImage(
                            modifier = Modifier.size(12.dp),
                            model = R.drawable.create_icon,
                            contentDescription = "Gradient background",
                        )
                    })
            },
        )
    }
}