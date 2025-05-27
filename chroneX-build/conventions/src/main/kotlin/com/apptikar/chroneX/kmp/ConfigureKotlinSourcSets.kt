package com.apptikar.chroneX.kmp

import com.apptikar.chroneX.kmp.androidMain.configureAndroidMainDependencies
import com.apptikar.chroneX.kmp.iosMain.configureIOSMainDependencies
import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun KotlinMultiplatformExtension.configureKotlinSourceSets(libs: LibrariesForLibs) {
    sourceSets.apply {
        sourceSets.apply {
            commonMain.dependencies {
                configureCommonMainDependencies(libs)
            }

            commonTest.dependencies {
                configureCommonTestingDependencies(libs)
            }
            androidMain.dependencies {
                configureAndroidMainDependencies(libs)
            }

            iosMain.dependencies {
                configureIOSMainDependencies(libs)
            }
        }
    }
}