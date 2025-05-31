import com.android.build.gradle.LibraryExtension
import com.apptikar.chroneX.alias
import com.apptikar.chroneX.android.configureAndroidBuildTypesOptions
import com.apptikar.chroneX.android.configureMinimalAndroidApplication
import com.apptikar.chroneX.coreLibraryDesugaring
import com.apptikar.chroneX.implementation
import com.apptikar.chroneX.kmp.configureCompileOptions
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

class AndroidLibraryConventionPlugin : Plugin<Project> {


    override fun apply(target: Project) {
        with(target)
        {

            val libs = the<LibrariesForLibs>()
            pluginManager.apply {
                alias(libs.plugins.androidLibrary)
                alias(libs.plugins.kotlin.parcelize)
                alias(libs.plugins.kotlinAndroid)
            }



            extensions.configure<LibraryExtension>()
            {
                defaultConfig {
                    minSdk = libs.versions.minSdk.get().toInt()
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    consumerProguardFiles("consumer-rules.pro")
                }
                configureMinimalAndroidApplication(libs)
                configureAndroidBuildTypesOptions()
                configureCompileOptions()
            }

            dependencies {
                coreLibraryDesugaring(libs.core.library.desugaring)
                implementation(libs.androidx.core.ktx)
                implementation(libs.bundles.lifecycle)
            }
        }
    }
}