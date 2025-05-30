package com.apptikar.chroneX.kmp


import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
internal fun CommonExtension<*,*,*, *, *, *>.configureCompileOptions() {
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
            isCoreLibraryDesugaringEnabled = true
        }
}