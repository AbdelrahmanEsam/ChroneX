package com.apptikar.chroneX.designSystem.font


sealed  class ChroneXFontSize(val size: Int) : Comparable<ChroneXFontSize> {

    sealed class Heading(size: Int) : ChroneXFontSize(size) {
        object HeadingOne : Heading(48)
        object HeadingTwo : Heading(40)
        object HeadingThree : Heading(32)
        object HeadingFour : Heading(24)
        object HeadingFive : Heading(20)
        object HeadingSix : Heading(18)
    }

    sealed class Body(size: Int) : ChroneXFontSize(size) {
        object BodyXLarge : Body(18)
        object BodyLarge : Body(16)
        object BodyMedium : Body(14)
        object BodySmall : Body(12)
        object BodyXSmall : Body(10)
    }


    override operator fun compareTo(other: ChroneXFontSize): Int {
        return size.compareTo(other.size)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ChroneXFontSize) return false
        if (size != other.size) return false
        return true

    }

    override fun hashCode(): Int {
        return size
    }

    override fun toString(): String {
        return "FontSize(size=$size)"
    }

}