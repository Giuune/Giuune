group = "com.project.giunne"
version = "1.0-SNAPSHOT"

plugins {
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.android.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.sqlDelght)
    kotlin("plugin.serialization")
}

sqldelight {
    databases {
    }
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions.jvmTarget = "17"
        }
    }
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "17"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.foundation)
                api(compose.material3)
                api(compose.runtime)
                api(compose.ui)
                api(compose.components.resources)

                api(libs.androidx.lifecycle.viewmodel)
                api(libs.androidx.lifecycle.runtime.compose)
                api(libs.androidx.collection)

                api(libs.koin.core)
                api(libs.napier)
                api(libs.bundles.ktor)
                api(libs.kotlinx.serialization.json)

                api(libs.decompose)
                api(libs.decompose.extention)

                api(libs.bundles.reaktive)

                api(libs.multiplatform.settings)

                api(libs.sqlDelight.runtime)
                api(libs.sqlDelight.adapter)

                api(libs.coil)
                api(libs.coil.compose)
                api(libs.coil.core)
                api(libs.coil.network.ktor2)

//                implementation("io.coil-kt.coil3:coil-network-okhttp:3.0.3")
//                api(libs.coil.core)
//                api(libs.coil.compose)
//                api(libs.coil.compose.core)
//                api(libs.coil.network.ktor)
            }
        }
        val androidMain by getting {
            dependencies {
                api(libs.androidx.appcompat)
                api(libs.androidx.core)
                api(libs.ktor.okHttp)
                api(libs.koin.core)
                api(libs.koin.android)
                api(libs.sqlDelight.android)
                api(libs.ktor.engine.android)
//                api(libs.multiplatform.resources.generator)
//                api(libs.coil.android)
            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.desktop.common)
                api(compose.preview)
                api(libs.skiko.macos)
                api(libs.ktor.okHttp)
                api(libs.koin.core)
                api(libs.koin.jvm)
                api(libs.reaktive.utils)
                api(libs.sqlDelight.jvm)
                api(libs.jdbc)
                api(libs.kotlinx.coroutines.swing)
                api(libs.ktor.engine.jvm)
            }
        }
    }
}

android {
    namespace = "com.project.giunne"
    compileSdk = 34
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 34

        multiDexEnabled = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildToolsVersion = "34.0.0"
}

compose.resources {
    publicResClass = true
    generateResClass = auto
    packageOfResClass = "com.project.giunne"
}