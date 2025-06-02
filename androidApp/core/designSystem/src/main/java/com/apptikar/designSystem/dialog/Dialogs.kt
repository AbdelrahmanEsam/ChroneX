package com.apptikar.designSystem.dialog

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil3.compose.AsyncImage
import com.chroneX.designSystem.R
import com.apptikar.designSystem.chroneXGray900
import com.apptikar.designSystem.chroneXPrimary100Color
import com.apptikar.designSystem.chroneXPrimary300Color
import com.apptikar.designSystem.chroneXPrimaryColor
import com.apptikar.designSystem.chroneXWhite
import com.apptikar.designSystem.headingFour

@Composable
fun ChroneModalDialog(
    isVisible: Boolean,
    onDismiss: () -> Unit,
    title: String,
    description: String,
    primaryButtonText: String,
    onPrimaryButtonClick: () -> Unit,
    secondaryButtonText: String,
    onSecondaryButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.chroneXWhite,
    titleColor: Color = MaterialTheme.colorScheme.chroneXPrimaryColor,
    descriptionColor: Color = MaterialTheme.colorScheme.chroneXGray900,
    primaryButtonColor: Color = MaterialTheme.colorScheme.chroneXPrimaryColor,
    primaryButtonTextColor: Color = MaterialTheme.colorScheme.chroneXWhite,
    secondaryButtonColor: Color = MaterialTheme.colorScheme.chroneXPrimary100Color,
    secondaryButtonTextColor: Color = MaterialTheme.colorScheme.chroneXPrimaryColor,
    circleColor: Color = MaterialTheme.colorScheme.chroneXPrimaryColor,
    decorativeDotsColor: Color = MaterialTheme.colorScheme.chroneXPrimary300Color
) {
    if (isVisible) {
        Dialog(onDismissRequest = onDismiss) {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = backgroundColor),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(160.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        DecorativeBackground(
                            color = decorativeDotsColor,
                            modifier = Modifier.fillMaxSize()
                        )

                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .background(
                                    color = circleColor,
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {

                            AsyncImage(
                                modifier = Modifier.size(40.dp),
                                model = R.drawable.tick_square,
                                contentDescription = "tick square",
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))


                    Text(
                        text = title,
                        style = MaterialTheme.typography.headingFour,
                        color = titleColor,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodyLarge,
                        color = descriptionColor,
                        textAlign = TextAlign.Center,
                        lineHeight = 20.sp
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        onClick = onPrimaryButtonClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = primaryButtonColor
                        ),
                        shape = RoundedCornerShape(24.dp)
                    ) {
                        Text(
                            text = primaryButtonText,
                            color = primaryButtonTextColor,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = onSecondaryButtonClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = secondaryButtonColor
                        ),
                        shape = RoundedCornerShape(24.dp)
                    ) {
                        Text(
                            text = secondaryButtonText,
                            color = secondaryButtonTextColor,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}




@Composable
private fun DecorativeBackground(
    color: Color,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        val dotPositions = listOf(
            Offset(canvasWidth * 0.15f, canvasHeight * 0.2f) to 8.dp.toPx(),
            Offset(canvasWidth * 0.85f, canvasHeight * 0.15f) to 4.dp.toPx(),
            Offset(canvasWidth * 0.9f, canvasHeight * 0.4f) to 12.dp.toPx(),
            Offset(canvasWidth * 0.1f, canvasHeight * 0.7f) to 6.dp.toPx(),
            Offset(canvasWidth * 0.8f, canvasHeight * 0.8f) to 5.dp.toPx(),
            Offset(canvasWidth * 0.25f, canvasHeight * 0.9f) to 7.dp.toPx()
        )

        dotPositions.forEach { (offset, radius) ->
            drawCircle(
                color = color,
                radius = radius,
                center = offset
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ChroneModalDialogPreview() {
    ChroneModalDialog(
        isVisible = true,
        onDismiss = {},
        title = "Action Required",
        description = "Please confirm this action to proceed. This cannot be undone.",
        primaryButtonText = "Confirm",
        onPrimaryButtonClick = {},
        secondaryButtonText = "Cancel",
        onSecondaryButtonClick = {}
    )
}