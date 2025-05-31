plugins {
    alias(libs.plugins.com.apptikar.chroneXbuild.library)
    alias(libs.plugins.com.apptikar.chroneXbuild.library.compose)
}

android {
    namespace = "com.apptikar.androidApp.core.designSystem"
}

dependencies{
    api(projects.shared)
}