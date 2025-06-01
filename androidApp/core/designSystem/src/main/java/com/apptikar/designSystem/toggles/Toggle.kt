package com.apptikar.designSystem.toggles

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.apptikar.designSystem.chroneXGray200
import com.apptikar.designSystem.chroneXPrimaryColor
import com.apptikar.designSystem.chroneXWhite

@Composable
fun ChroneXSwitch(
    checked: Boolean,
    backgroundColor: Color  = MaterialTheme.colorScheme.chroneXPrimaryColor,
    uncheckedBackgroundColor: Color = MaterialTheme.colorScheme.chroneXGray200,
    thumbColor: Color = MaterialTheme.colorScheme.chroneXWhite,
    onCheckedChange: (Boolean) -> Unit
) {
    Switch(
        colors = colors(
            checkedBorderColor = Color.Transparent,
            uncheckedBorderColor = Color.Transparent,
            checkedThumbColor = thumbColor,
            checkedTrackColor = backgroundColor,
            uncheckedThumbColor = thumbColor,
            uncheckedTrackColor = uncheckedBackgroundColor
        ),
        checked = checked,
        onCheckedChange = onCheckedChange
    )
}

@Preview
@Composable
fun ChroneXSwitchPreview() {
    ChroneXSwitch(
        checked = true,
        onCheckedChange = {}
    )
}

@Preview
@Composable
fun ChroneXSwitchUncheckedPreview() {
    ChroneXSwitch(
        checked = false,
        onCheckedChange = {}
    )
}



