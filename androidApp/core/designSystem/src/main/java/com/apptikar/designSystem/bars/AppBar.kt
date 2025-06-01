package com.apptikar.designSystem.bars

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.apptikar.designSystem.R
import com.apptikar.designSystem.chroneXBlack
import com.apptikar.designSystem.chroneXPrimaryColor
import com.apptikar.designSystem.chroneXWhite
import com.apptikar.designSystem.headingFour

@Composable
fun ChroneHeader(
    title: String,
    onBackClick: () -> Unit,
    onCreateClick: () -> Unit,
    modifier: Modifier = Modifier,
    showLogo: Boolean = false,
    backgroundColor: Color = MaterialTheme.colorScheme.chroneXWhite,
    titleColor: Color = MaterialTheme.colorScheme.chroneXBlack,
    createButtonColor: Color = MaterialTheme.colorScheme.chroneXPrimaryColor,
    createButtonTextColor: Color = MaterialTheme.colorScheme.chroneXPrimaryColor,
    createButtonText: String,
    showCreateButton: Boolean = true,
    elevation: Dp = 0.dp
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

                if (showLogo) {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier.size(40.dp)
                    ) {
                        AsyncImage(
                            modifier = Modifier.size(30.dp),
                            model = R.drawable.logo,
                            contentDescription = "Gradient background",
                        )
                    }
                }



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

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = title,
                    style = MaterialTheme.typography.headingFour,
                    color = titleColor
                )
            }


            if (showCreateButton) {
                Button(
                    onClick = onCreateClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(20.dp),
                    contentPadding = PaddingValues(
                        horizontal = 16.dp,
                    ),
                    modifier = Modifier
                        .height(36.dp)
                        .border(
                            width = 2.dp,
                            color = createButtonColor,
                            shape = RoundedCornerShape(25.dp)
                        )
                ) {
                    AsyncImage(
                        modifier = Modifier.size(12.dp),
                        model = R.drawable.create_icon,
                        contentDescription = "Gradient background",
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = createButtonText,
                        color = createButtonTextColor,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
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
            onCreateClick = { /*TODO*/ },
            createButtonText = "Create",
            showLogo = true
        )
    }
}