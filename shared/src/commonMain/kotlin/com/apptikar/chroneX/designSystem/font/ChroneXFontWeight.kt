package com.apptikar.chroneX.designSystem.font

import com.apptikar.chroneX.designSystem.font.ChroneXFontSize.Heading

sealed class ChroneXFontWeight(val weight: Int) : Comparable<ChroneXFontWeight> {
    object Thin : ChroneXFontWeight(100)

    object ExtraLight : ChroneXFontWeight(200)


    object Light : ChroneXFontWeight(300)


    object Normal : ChroneXFontWeight(400)


    object Medium : ChroneXFontWeight(500)


    object SemiBold : ChroneXFontWeight(600)


    object Bold : ChroneXFontWeight(700)


    object ExtraBold : ChroneXFontWeight(800)

    object Black : ChroneXFontWeight(900)


    override operator fun compareTo(other: ChroneXFontWeight): Int {
        return weight.compareTo(other.weight)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ChroneXFontWeight) return false
        if (weight != other.weight) return false
        return true

    }

    override fun hashCode(): Int {
        return weight
    }

    override fun toString(): String {
        return "FontWeight(weight=$weight)"
    }

}