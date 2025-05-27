package com.apptikar.chroneX.android

import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.accessors.dm.LibrariesForLibs
import kotlin.text.get
import kotlin.text.toInt

fun CommonExtension<*,*,*, *, *, *>.configureMinimalAndroidApplication(libs: LibrariesForLibs)
{
    namespace = libs.versions.application.id.get()
    compileSdk = libs.versions.compileSdk.get().toInt()
}