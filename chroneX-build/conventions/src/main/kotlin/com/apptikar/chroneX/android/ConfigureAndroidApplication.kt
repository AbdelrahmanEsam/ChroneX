package com.apptikar.chroneX.android

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.apptikar.chroneX.kmp.configureCompileOptions
import org.gradle.accessors.dm.LibrariesForLibs

internal fun BaseAppModuleExtension.configureAndroidApplication(libs : LibrariesForLibs)
{
   configureMinimalAndroidApplication(libs)
   configureAndroidDefaultConfig(libs)
   configureAndroidPackagingOptions()
   configureAndroidBuildTypesOptions()
    configureCompileOptions()
}