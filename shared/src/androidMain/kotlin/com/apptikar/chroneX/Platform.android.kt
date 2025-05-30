package com.apptikar.chroneX

import com.apptikar.chroneX.designSystem.font.ChroneXFontWeight

class AndroidPlatform : Platform {
    override val name: String = "Android"
}

actual fun getPlatform(): Platform = AndroidPlatform()
