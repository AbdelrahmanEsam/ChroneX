package com.apptikar.chroneX

import org.gradle.api.Project
import org.gradle.kotlin.dsl.maven
import org.gradle.kotlin.dsl.repositories

internal fun Project.configureRepositories() {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}