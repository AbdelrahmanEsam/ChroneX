package com.apptikar.chroneX.android
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.accessors.dm.LibrariesForLibs


fun BaseAppModuleExtension.configureAndroidDefaultConfig(libs: LibrariesForLibs)
{
    defaultConfig {
        applicationId = libs.versions.application.id.get()
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
}