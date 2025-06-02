plugins {
    alias(libs.plugins.com.apptikar.chroneXbuild.android.application)
}

dependencies{
    implementation(projects.androidApp.core.utils)
    implementation(projects.androidApp.core.designSystem)
}


android {
    sourceSets["main"].assets.srcDirs("src/commonMain/resources")
}
