import org.jetbrains.compose.desktop.application.dsl.TargetFormat

group = "com.project.giunnae"
version = "1.0-SNAPSHOT"

plugins {
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.ksp)
}

kotlin {
    jvm {
        withJava()
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(project(":common"))
                implementation(libs.compose.ui.util)
                implementation(compose.desktop.currentOs)
                implementation(libs.skiko.macos)
                implementation(libs.slf4j)
            }
        }
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            modules("java.sql", "java.instrument", "java.compiler", "jdk.unsupported")
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Giunnae"
            packageVersion = "1.0.0"
        }
        jvmArgs += listOf(
            "-Xmx2G"
        )
    }
}

//buildscript {
//    dependencies {
//        classpath (libs.multiplatform.resources.generator)
//    }
//}