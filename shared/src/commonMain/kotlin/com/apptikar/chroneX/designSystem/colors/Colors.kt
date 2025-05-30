package com.apptikar.chroneX.designSystem.colors


sealed class ChroneXColors(val color: Long) {
    data object PrimaryColor : ChroneXColors(0xFF12D18E)
    data object SecondaryColor : ChroneXColors(0xFF12D18E)

    sealed class AlertsAndStatusColors(color: Long) : ChroneXColors(color) {
        data object Success : AlertsAndStatusColors(0xFF12D18E)
        data object Warning : AlertsAndStatusColors(0xFFFACC15)
        data object Error : AlertsAndStatusColors(0xFFF75555)
        data object Disabled : AlertsAndStatusColors(0xFFD8D8D8)
        data object DisabledButton : AlertsAndStatusColors(0xFF0EA772)
    }

    sealed class GrayScale(color: Long) : ChroneXColors(color) {
        data object Gray900 : GrayScale(0xFF212121)
        data object Gray800 : GrayScale(0xFF424242)
        data object Gray700 : GrayScale(0xFF616161)
        data object Gray600 : GrayScale(0xFF757575)
        data object Gray500 : GrayScale(0xFF9E9E9E)
        data object Gray400 : GrayScale(0xFFBDBDBD)
        data object Gray300 : GrayScale(0xFFE0E0E0)
        data object Gray200 : GrayScale(0xFFEEEEEE)
        data object Gray100 : GrayScale(0xFFF5F5F5)
        data object Gray50 : GrayScale(0xFFFAFAFA)
    }


    sealed class DarkColors(color: Long) : ChroneXColors(color) {
        data object DarkOne : DarkColors(0xFF181A20)
        data object DarkTwo : DarkColors(0xFF1F222A)
        data object DarkThree : DarkColors(0xFF35383F)
    }


    sealed class Others(color: Long) : ChroneXColors(color) {
        data object White : Others(0xFFFFFFFF)
        data object Black : Others(0xFF000000)
        data object Red : Others(0xFF44336)
        data object Pink : Others(0xFFE91E63)
        data object Purple : Others(0xFF9C27B0)
        data object DeepPurple : Others(0xFF9C27B0)
        data object Indigo : Others(0xFF3F51B5)
        data object Blue : Others(0xFF2196F3)
        data object LightBlue : Others(0xFF03A9F4)
        data object Cyan : Others(0xFF00BCD4)
        data object Teal : Others(0xFF009688)
        data object Green : Others(0xFF4CAF50)
        data object LightGreen : Others(0xFF8BC34A)
        data object Lime : Others(0xFFCDDC39)
        data object Yellow : Others(0xFFFFEB3B)
        data object Amber : Others(0xFFFFC107)
        data object Orange : Others(0xFFFF9800)
        data object DeepOrange : Others(0xFFFF5722)
        data object Brown : Others(0xFF795548)
        data object BlueGrey : Others(0xFF607D8B)
    }

    sealed class Backgrounds(color: Long) : ChroneXColors(color) {
        data object Green : Backgrounds(0xFFF1FDF5)
        data object Yellow : Backgrounds(0xFFFFFCEB)
        data object Blue : Backgrounds(0xFFF6F9FF)
        data object Purple : Backgrounds(0xFFF9F8FF)
        data object Teal : Backgrounds(0xFFF2FFFD)
        data object Red : Backgrounds(0xFFFFF7F8)
        data object Orange : Backgrounds(0xFFFFF8ED)
    }

    sealed class Transparent(color: Long) : ChroneXColors(color) {
        data object Green : Transparent(0xFF12D18E)
        data object Yellow : Transparent(0xFFFFD300)
        data object Blue : Transparent(0xFF246BFD)
        data object Purple : Transparent(0xFF6949FF)
        data object Teal : Transparent(0xFF019B83)
        data object Red : Transparent(0xFFFF5A5F)
        data object Orange : Transparent(0xFFFF9800)
        data object Cyan : Transparent(0xFF00BCD4)
    }
}

