/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * To learn more about Gradle by exploring our Samples at https://docs.gradle.org/8.7/samples
 */

plugins {
    kotlin("multiplatform") version "1.9.24"
}

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://oss.sonatype.org/content/repositories/orgjetbrainskotlinx-3346")
}

kotlin {
    targets {
        macosArm64()
        macosX64()
        linuxX64()
        mingwX64()

        jvm()

        js(IR) {
            nodejs()
        }

        if (project.findProperty("withWasm") == "true") {
            wasmJs {
                nodejs()
            }
            wasmWasi {
                nodejs()
            }
        }

    }

    sourceSets {
        commonMain {
            dependencies {
                // compiled with 2.0.0-RC3
                implementation("org.jetbrains.kotlinx:kotlinx-io-core:0.4.0-alpha")
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}