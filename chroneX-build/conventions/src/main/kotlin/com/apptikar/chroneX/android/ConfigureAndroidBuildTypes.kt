package com.apptikar.chroneX.android

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension


internal fun BaseAppModuleExtension.configureAndroidBuildTypesOptions()
{
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}