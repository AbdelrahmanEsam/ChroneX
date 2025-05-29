import com.android.build.gradle.LibraryExtension
import com.apptikar.chroneX.android.configureMinimalAndroidApplication
import com.apptikar.chroneX.kmp.configureKmpConfig
import com.apptikar.chroneX.libs
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

class KMPLibraryConventionPlugin : Plugin<Project> {


    override fun apply(target: Project) {
        with(target)
        {


            configureKmpConfig()



            extensions.configure<LibraryExtension>()
            {
                defaultConfig.targetSdk = libs.versions.targetSdk.get().toInt()
                configureMinimalAndroidApplication(libs)
            }

            dependencies {

            }

        }
    }
}