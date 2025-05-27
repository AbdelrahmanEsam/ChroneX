package com.apptikar.chroneX.kmp.iosMain

import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

internal fun KotlinDependencyHandler.configureIOSMainDependencies(libs: LibrariesForLibs) {
    implementation(libs.ktor.client.darwin)
}