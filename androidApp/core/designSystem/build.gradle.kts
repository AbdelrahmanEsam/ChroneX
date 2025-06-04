plugins {
    alias(libs.plugins.com.apptikar.chroneXbuild.library)
    alias(libs.plugins.com.apptikar.chroneXbuild.library.compose)
}

android {
    namespace = "${libs.versions.application.id.get()}.designSystem"
}

dependencies{
    implementation(libs.credentials)
    implementation(libs.credentials.play.services.auth)
    implementation(libs.googleid)
    implementation(libs.googleAuth)
    implementation(libs.bundles.coil)
    api(projects.shared)
}