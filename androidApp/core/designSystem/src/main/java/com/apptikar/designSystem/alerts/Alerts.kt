package com.apptikar.designSystem.alerts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.chroneX.designSystem.R
import com.apptikar.designSystem.chroneXBlueTransparent
import com.apptikar.designSystem.chroneXErrorColor
import com.apptikar.designSystem.chroneXGreen
import com.apptikar.designSystem.chroneXGreenBackground
import com.apptikar.designSystem.chroneXOrange
import com.apptikar.designSystem.chroneXPurpleTransparent
import com.apptikar.designSystem.chroneXWarningColor


@Composable
fun AlertMessage(
    message: String,
    backgroundColor: Color,
    textColor: Color,
    iconColor: Color = textColor,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            AsyncImage(
                modifier = Modifier.size(20.dp),
                model = R.drawable.warning,
                colorFilter = ColorFilter.tint(iconColor),
                contentDescription = "Gradient background",
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = message,
                color = textColor,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun SuccessAlertMessage(modifier: Modifier = Modifier, message: String) = AlertMessage(
    modifier = modifier,
    message = message,
    backgroundColor = MaterialTheme.colorScheme.chroneXGreenBackground,
    textColor = MaterialTheme.colorScheme.chroneXGreen,
)

@Composable
fun ErrorAlertMessage(modifier: Modifier = Modifier, message: String) = AlertMessage(
    modifier = modifier,
    message = message,
    backgroundColor = MaterialTheme.colorScheme.chroneXErrorColor.copy(alpha = 0.2f),
    textColor = MaterialTheme.colorScheme.chroneXErrorColor,
)

@Composable
fun WarningAlertMessage(modifier: Modifier = Modifier, message: String) = AlertMessage(
    modifier = modifier,
    message = message,
    backgroundColor = MaterialTheme.colorScheme.chroneXWarningColor.copy(0.2f),
    textColor = MaterialTheme.colorScheme.chroneXOrange,
)

@Composable
fun InfoAlertMessage(modifier: Modifier = Modifier, message: String) = AlertMessage(
    modifier = modifier,
    message = message,
    backgroundColor = MaterialTheme.colorScheme.chroneXBlueTransparent.copy(0.2f),
    textColor = MaterialTheme.colorScheme.chroneXPurpleTransparent,
)


@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun AlertMessageSuccessPreview() {
    SuccessAlertMessage(
        message = "Success Message",
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun AlertMessageErrorPreview() {
    ErrorAlertMessage(
        message = "Error Message",
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun AlertMessageWarningPreview() {
    WarningAlertMessage(
        message = "Warning Message",
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun AlertMessageInformativePreview() {
    InfoAlertMessage(
        message = "Info Message",
    )
}
