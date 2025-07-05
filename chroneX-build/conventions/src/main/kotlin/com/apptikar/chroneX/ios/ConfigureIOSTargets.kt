package com.apptikar.chroneX.ios

import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinTargetContainerWithPresetFunctions
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.swiftexport.SwiftExportExtension
import org.jetbrains.kotlin.gradle.swiftexport.ExperimentalSwiftExportDsl


internal fun KotlinTargetContainerWithPresetFunctions.configureIOSTargets() {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = false
        }
    }
}


@OptIn(ExperimentalSwiftExportDsl::class)
internal fun KotlinMultiplatformExtension.configureDirectSwiftExport() {
    extensions.findByType(SwiftExportExtension::class.java)?.apply {
        moduleName.set("Shared")

        flattenPackage.set("com.apptikar.chroneXbuild")
    }
}