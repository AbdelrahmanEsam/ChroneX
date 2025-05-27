package com.apptikar.chroneX.kmp

import com.apptikar.chroneX.alias
import com.apptikar.chroneX.libs
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension


internal fun Project.configureKmpConfig() {
    pluginManager.apply{
        alias(libs.plugins.kotlinMultiplatform)
        alias(libs.plugins.androidLibrary)
        alias(libs.plugins.kotlinx.serialization.plugin)
        alias(libs.plugins.kotlin.parcelize)
        alias(libs.plugins.gradle.secrets)
    }


    extensions.findByType(KotlinMultiplatformExtension::class.java)?.apply {
        configureKMPTargets()
        configureKotlinSourceSets(libs)
    }
}