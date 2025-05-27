package com.apptikar.chroneX.android

import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension


internal fun CommonExtension<*,*,*, *, *, *>.configureAndroidPackagingOptions()
{
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}