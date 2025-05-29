import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.apptikar.chroneX.alias
import com.apptikar.chroneX.android.configureAndroidApplication
import com.apptikar.chroneX.android.configureAndroidCompose
import com.apptikar.chroneX.coreLibraryDesugaring
import com.apptikar.chroneX.debugImplementation
import com.apptikar.chroneX.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target)
        {

            pluginManager.apply{
                alias(libs.plugins.androidApplication)
                alias(libs.plugins.kotlinAndroid)
                alias(libs.plugins.compose.compiler)
            }

            extensions.findByType(CommonExtension::class.java)?.apply {
                configureAndroidCompose(this)
            }

            extensions.findByType(BaseAppModuleExtension::class.java)?.apply {
                configureAndroidApplication(libs)
            }

            dependencies {
                coreLibraryDesugaring(libs.core.library.desugaring)
                debugImplementation(libs.compose.ui.tooling)
            }
        }
    }
}