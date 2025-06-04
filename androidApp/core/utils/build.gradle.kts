plugins {
    alias(libs.plugins.com.apptikar.chroneXbuild.library)
    alias(libs.plugins.com.apptikar.chroneXbuild.library.compose)
}

android {
    namespace = "${libs.versions.application.id.get()}.utils"
}
