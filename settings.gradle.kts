enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    includeBuild("chroneX-build")
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ChroneX"
include(":androidApp")
include(":shared")
include(":androidApp:core")
include(":androidApp:core:designSystem")
include(":androidApp:core:utils")
