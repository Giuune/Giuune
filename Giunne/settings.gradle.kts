pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "Giunnae"

include(":android", ":desktop", ":common")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")