package com.apptikar.chroneX

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal fun Project.configureSigningConfigs() {
    extensions.configure<ApplicationExtension>
    {
        //todo
        signingConfigs {
            create("release") {

            }
        }
    }
}