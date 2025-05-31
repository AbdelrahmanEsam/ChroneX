package com.apptikar.designSystem

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.apptikar.chroneX.designSystem.font.ChroneXFontSize
import com.apptikar.chroneX.designSystem.font.ChroneXFontWeight
import androidx.compose.material3.Typography
// typography from ChroneXFontWeights and ChroneXFontSizes


val Typography.headingOne: TextStyle
    get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = ChroneXFontWeight.Bold.toComposeFontWeight(),
        fontSize = ChroneXFontSize.Heading.HeadingOne.size.sp,
    )



val Typography.headingTwo: TextStyle
    get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = ChroneXFontWeight.Bold.toComposeFontWeight(),
        fontSize = ChroneXFontSize.Heading.HeadingTwo.size.sp,
    )

val Typography.headingThree: TextStyle
    get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = ChroneXFontWeight.Bold.toComposeFontWeight(),
        fontSize = ChroneXFontSize.Heading.HeadingThree.size.sp,
    )


val Typography.headingFour: TextStyle
    get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = ChroneXFontWeight.Bold.toComposeFontWeight(),
        fontSize = ChroneXFontSize.Heading.HeadingFour.size.sp,
    )


val Typography.headingFive: TextStyle
    get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = ChroneXFontWeight.Bold.toComposeFontWeight(),
        fontSize = ChroneXFontSize.Heading.HeadingFive.size.sp,
    )

val Typography.headingSix: TextStyle
    get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = ChroneXFontWeight.Bold.toComposeFontWeight(),
        fontSize = ChroneXFontSize.Heading.HeadingSix.size.sp,
    )

// body text styles

val Typography.bodyXLarge: TextStyle
    get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = ChroneXFontWeight.Normal.toComposeFontWeight(),
        fontSize = ChroneXFontSize.Body.BodyXLarge.size.sp,
    )

val Typography.BodyLarge: TextStyle
    get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = ChroneXFontWeight.Normal.toComposeFontWeight(),
        fontSize = ChroneXFontSize.Body.BodyLarge.size.sp,
    )

val Typography.BodyMedium: TextStyle
    get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = ChroneXFontWeight.Normal.toComposeFontWeight(),
        fontSize = ChroneXFontSize.Body.BodyMedium.size.sp,
    )


val Typography.BodySmall: TextStyle
    get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = ChroneXFontWeight.Normal.toComposeFontWeight(),
        fontSize = ChroneXFontSize.Body.BodySmall.size.sp,
    )


val Typography.BodyXSmall: TextStyle
    get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = ChroneXFontWeight.Normal.toComposeFontWeight(),
        fontSize = ChroneXFontSize.Body.BodyXSmall.size.sp,
    )






fun ChroneXFontWeight.toComposeFontWeight(): FontWeight {
    return when (this) {
        ChroneXFontWeight.Black -> FontWeight.Black
        ChroneXFontWeight.Bold -> FontWeight.Bold
        ChroneXFontWeight.ExtraBold -> FontWeight.ExtraBold
        ChroneXFontWeight.ExtraLight -> FontWeight.ExtraLight
        ChroneXFontWeight.Light -> FontWeight.Light
        ChroneXFontWeight.Medium -> FontWeight.Medium
        ChroneXFontWeight.Normal -> FontWeight.Normal
        ChroneXFontWeight.SemiBold -> FontWeight.SemiBold
        ChroneXFontWeight.Thin -> FontWeight.Thin
    }
}
