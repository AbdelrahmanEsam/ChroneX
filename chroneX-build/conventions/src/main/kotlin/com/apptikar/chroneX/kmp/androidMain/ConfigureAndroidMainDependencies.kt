package com.apptikar.chroneX.kmp.androidMain

import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler


internal fun KotlinDependencyHandler.configureAndroidMainDependencies(libs: LibrariesForLibs) {
    implementation(libs.bundles.pagination)
    implementation(libs.android.startup.runtime)
    implementation(libs.ktor.client.android)
    implementation(libs.pagination.compose)
    implementation(libs.koin.android)

}