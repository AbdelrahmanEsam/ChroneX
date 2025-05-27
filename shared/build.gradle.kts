import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinx.serialization.plugin)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.gradle.secrets)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_21)
                }
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.bundles.pagination)
            implementation(libs.android.startup.runtime)
            implementation(libs.ktor.client.android)
            implementation(libs.pagination.compose)
            implementation(libs.koin.android)
        }

        commonMain.dependencies {
            implementation(libs.bundles.ktor)
            implementation(libs.bundles.koin)
            implementation(libs.androidx.annotation)
            api(libs.kotlinx.serialization)
            api(libs.datastore.preferences)
            api(libs.datastore)
            //put your multiplatform dependencies here
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.apptikar.chroneX"
    compileSdk = libs.versions.compileSdk.get().toInt()
}
