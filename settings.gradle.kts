pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "todo-backend"

// gradle plugins module
includeBuild("todo-plugins")

// gradle subprojects
include("todo-api")
include("todo-core")
