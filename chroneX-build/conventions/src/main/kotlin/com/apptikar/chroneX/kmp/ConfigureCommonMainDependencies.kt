package com.apptikar.chroneX.kmp

import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import kotlin.jvm.kotlin

internal fun KotlinDependencyHandler.configureCommonMainDependencies(libs: LibrariesForLibs) {
    implementation(libs.bundles.ktor)
    implementation(libs.bundles.koin)
    implementation(libs.androidx.annotation)
    api(libs.kotlinx.serialization)
    api(libs.datastore.preferences)
    api(libs.datastore)
}

internal fun KotlinDependencyHandler.configureCommonTestingDependencies(libs: LibrariesForLibs) {
    implementation(libs.kotlin.test)
}