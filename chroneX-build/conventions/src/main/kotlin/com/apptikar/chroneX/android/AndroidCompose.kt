package com.apptikar.chroneX.android

import com.android.build.api.dsl.CommonExtension
import com.apptikar.chroneX.alias
import com.apptikar.chroneX.implementation
import com.apptikar.chroneX.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies


internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*,*,*, *, *, *>,
)
{

    commonExtension.apply {

        pluginManager.apply {
            alias(libs.plugins.compose.compiler)
        }


        buildFeatures {
            compose = true
        }

        dependencies {
            implementation(libs.compose.ui)
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.compose.material3)
            implementation(libs.androidx.activity.compose)
        }
    }

}