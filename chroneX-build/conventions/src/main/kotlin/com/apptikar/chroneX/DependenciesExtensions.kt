package com.apptikar.chroneX

import com.android.build.gradle.AbstractAppExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.PluginManager
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.the
import org.gradle.plugin.use.PluginDependency


internal val Project.libs get() = the<LibrariesForLibs>()
internal val Project.abstractApp get() = the<AbstractAppExtension>()



fun DependencyHandler.implementation(
    dependencyNotation: Any,
): Dependency? {
    return add("implementation", dependencyNotation)
}


fun DependencyHandler.testImplementation(
    dependencyNotation: Any,
): Dependency? {
    return add("testImplementation", dependencyNotation)
}

fun DependencyHandler.api(
    dependencyNotation: Any,
): Dependency? {
    return add("api", dependencyNotation)
}

fun DependencyHandler.debugImplementation(
    dependencyNotation: Any,
): Dependency? {
    return add("debugImplementation", dependencyNotation)
}
fun DependencyHandler.androidTestImplementation(
    dependencyNotation: Any,
): Dependency? {
    return add("androidTestImplementation", dependencyNotation)
}

fun DependencyHandler.compileOnly(
    dependencyNotation: Any,
): Dependency? {
    return add("compileOnly", dependencyNotation)
}

fun DependencyHandler.annotationProcessor(
    dependencyNotation: Any,
): Dependency? {
    return add("annotationProcessor", dependencyNotation)
}


fun DependencyHandler.lintChecks(
    dependencyNotation: Any,
): Dependency? {
    return add("lintChecks", dependencyNotation)
}

fun DependencyHandler.coreLibraryDesugaring(
    dependencyNotation: Any,
): Dependency? {
    return add("coreLibraryDesugaring", dependencyNotation)
}

fun PluginManager.alias(pluginDependency: Provider<PluginDependency>)
{
    this.apply(pluginDependency.get().pluginId)
}