package com.apptikar.chroneX

import com.apptikar.chroneX.designSystem.font.ChroneXFontSize

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${ChroneXFontSize.Body.BodyMedium.size}!"
    }
}