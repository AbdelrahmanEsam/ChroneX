plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.kotlinx.serialization.plugin) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.gradle.secrets) apply false
    alias(libs.plugins.android.kotlin.multiplatform.library) apply false
    alias(libs.plugins.com.apptikar.chroneXbuild.kmp.shared) apply false
    alias(libs.plugins.com.apptikar.chroneXbuild.android.application) apply false
    alias(libs.plugins.androidLibrary) apply false
}
