package com.apptikar.chroneX.android

import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension


internal fun CommonExtension<*,*,*, *, *, *>.configureAndroidBuildTypesOptions()
{
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}