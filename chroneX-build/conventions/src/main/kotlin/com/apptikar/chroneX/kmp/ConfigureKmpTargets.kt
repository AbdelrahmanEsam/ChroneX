package com.apptikar.chroneX.kmp

import com.apptikar.chroneX.android.configureAndroidTargets
import com.apptikar.chroneX.ios.configureIOSTargets
import com.apptikar.chroneX.ios.configureDirectSwiftExport
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun KotlinMultiplatformExtension.configureKMPTargets() {
    configureAndroidTargets()
    configureIOSTargets()
    configureDirectSwiftExport()
}