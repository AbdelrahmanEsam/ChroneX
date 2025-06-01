plugins {
    alias(libs.plugins.com.apptikar.chroneXbuild.library)
    alias(libs.plugins.com.apptikar.chroneXbuild.library.compose)
}

android {
    namespace = "com.apptikar.designSystem"
}

dependencies{
    api(libs.credentials)
    api(libs.credentials.play.services.auth)
    api(libs.googleid)
    api(libs.googleAuth)
    api(libs.bundles.coil)
    api(projects.shared)
}