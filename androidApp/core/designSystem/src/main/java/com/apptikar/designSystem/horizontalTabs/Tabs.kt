package com.apptikar.designSystem.horizontalTabs

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.chroneX.designSystem.R
import com.apptikar.designSystem.bodyXLarge
import com.apptikar.designSystem.chroneXGray300
import com.apptikar.designSystem.chroneXGray500
import com.apptikar.designSystem.chroneXPrimaryColor
import com.apptikar.designSystem.chroneXWhite

@Composable
fun ChroneHorizontalTab(
    tab: ChroneTab,
    isActive: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    activeColor: Color = MaterialTheme.colorScheme.chroneXPrimaryColor,
    inactiveColor: Color = MaterialTheme.colorScheme.chroneXGray500,
    indicatorColor: Color = MaterialTheme.colorScheme.chroneXPrimaryColor,
    leadingComposable: @Composable (() -> Unit)? = null,
    trailingComposable: @Composable (() -> Unit)? = null,
    showIndicator: Boolean = true
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        leadingComposable?.invoke()
        Column(
            modifier = modifier
                .clickable { onClick() }
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = tab.title,
                color = if (isActive) activeColor else inactiveColor,
                style = MaterialTheme.typography.bodyXLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            if (showIndicator) {
                Box(
                    modifier = Modifier
                        .height(2.dp)
                        .width(if (isActive) 40.dp else 0.dp)
                        .background(
                            color = if (isActive) indicatorColor else Color.Transparent,
                            shape = RoundedCornerShape(1.dp)
                        )
                        .animateContentSize(
                            animationSpec = tween(
                                durationMillis = 200,
                                easing = FastOutSlowInEasing
                            )
                        )
                )
            }
        }
        trailingComposable?.invoke()
    }
}


@Composable
fun ChroneHorizontalTabRow(
    tabs: List<ChroneTab>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    activeColor: Color = MaterialTheme.colorScheme.chroneXPrimaryColor,
    inactiveColor: Color = MaterialTheme.colorScheme.chroneXGray300,
    backgroundColor: Color = MaterialTheme.colorScheme.chroneXWhite,
    indicatorColor: Color = MaterialTheme.colorScheme.chroneXPrimaryColor,
    dividerColor: Color = MaterialTheme.colorScheme.chroneXGray300,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            tabs.forEachIndexed { index, tab ->


                ChroneHorizontalTab(
                    tab = tab,
                    isActive = selectedTabIndex == index,
                    onClick = { onTabSelected(index) },
                    activeColor = activeColor,
                    inactiveColor = inactiveColor,
                    indicatorColor = indicatorColor,
                    leadingComposable = {
                        AsyncImage(
                            modifier = Modifier.size(30.dp),
                            model = tab.leadingIcon,
                            contentDescription = "leading image",
                            colorFilter = ColorFilter.tint( if (selectedTabIndex == index) activeColor else inactiveColor)
                        )
                    },
                    trailingComposable = {
                        AsyncImage(
                            modifier = Modifier.size(30.dp),
                            model = tab.trailingIcon,
                            contentDescription = "trailing image",
                            colorFilter = ColorFilter.tint( if (selectedTabIndex == index) activeColor else inactiveColor)

                        )
                    }
                )
            }
        }

        HorizontalDivider(modifier, 2.dp, dividerColor)
    }
}



@Preview
@Composable
fun ChroneHorizontalTabRowPreview() {
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }
    ChroneHorizontalTabRow(
        tabs = listOf(
            ChroneTab(
                title = "tab1",
                leadingIcon = R.drawable.logo,
                trailingIcon = R.drawable.logo,
            ), ChroneTab(title = "tab 2"), ChroneTab(title = "tab 3")
        ),
        selectedTabIndex = selectedTabIndex,
        onTabSelected = {
            selectedTabIndex = it
        }
    )
}


data class ChroneTab(
    val title: String,
    @DrawableRes val trailingIcon: Int? = null,
    @DrawableRes val leadingIcon: Int? = null
)




