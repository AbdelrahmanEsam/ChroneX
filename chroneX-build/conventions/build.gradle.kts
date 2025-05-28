plugins {
    `kotlin-dsl`
}

group = "com.apptikar.chroneXbuild"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}


dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)

    // Enables using type-safe accessors to reference plugins from the [plugins] block defined in version catalogs.
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {

    fun createPlugin(id: String, className: String) {
        plugins.create(id) {
            this.id = id
            implementationClass = className
        }
    }
    createPlugin("com.apptikar.chroneXbuild.android", "AndroidApplicationConventionPlugin")

}