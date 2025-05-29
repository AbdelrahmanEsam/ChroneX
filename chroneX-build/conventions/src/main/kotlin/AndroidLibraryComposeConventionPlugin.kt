import com.android.build.gradle.LibraryExtension
import com.apptikar.chroneX.android.configureAndroidCompose
import com.apptikar.chroneX.implementation
import com.apptikar.chroneX.libs
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.the

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")

            }
            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)





            dependencies {
                implementation(libs.compose.foundation)
                implementation(libs.compose.material3)
                implementation(libs.compose.ui)
                implementation(libs.compose.ui.tooling)
                implementation(libs.compose.ui.tooling.preview)
                implementation(libs.navigation.compose)
                implementation(libs.koin.compose)
                implementation(libs.pagination.compose)
            }
        }


    }

}