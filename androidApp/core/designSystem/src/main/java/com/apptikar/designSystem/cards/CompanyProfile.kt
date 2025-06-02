package com.apptikar.designSystem.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.apptikar.designSystem.chroneXGray600
import com.apptikar.designSystem.chroneXGray900
import com.apptikar.designSystem.headingSix

@Composable
fun ChroneCompanyHeader(
    profileImageUrl: String?,
    companyName: String,
    companyCode: String,
    modifier: Modifier = Modifier,
    profileImageSize: Dp = 48.dp,
    backgroundColor: Color = Color.Transparent,
    companyNameColor: Color = MaterialTheme.colorScheme.chroneXGray900,
    companyCodeColor: Color = MaterialTheme.colorScheme.chroneXGray600,
    contentPadding: Dp = 16.dp,
    spacing: Dp = 12.dp,
    profileImageShape: Shape = CircleShape,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(contentPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(spacing)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(profileImageUrl)
                .build(),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(profileImageSize)
                .clip(profileImageShape),
            contentScale = ContentScale.Crop,
        )


        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = companyName,
                style = MaterialTheme.typography.headingSix,
                color = companyNameColor,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = companyCode,
                style = MaterialTheme.typography.bodyMedium,
                color = companyCodeColor
            )
        }
    }
}

