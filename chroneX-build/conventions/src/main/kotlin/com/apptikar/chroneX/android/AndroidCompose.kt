package com.apptikar.chroneX.android

import com.android.build.api.dsl.CommonExtension
import com.apptikar.chroneX.alias
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the


internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*,*,*, *, *, *>,
)
{
    val libs = the<LibrariesForLibs>()

    commonExtension.apply {

        pluginManager.apply {
            alias(libs.plugins.compose.compiler)
        }


        buildFeatures {
            compose = true
        }
    }

}