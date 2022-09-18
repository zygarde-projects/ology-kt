plugins {
    kotlin("js") version "1.6.21"
}

group = "ology"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-nodejs:0.0.7")
    implementation(npm("@nut-tree/nut-js", "next"))
    implementation(npm("@nut-tree/template-matcher", "next"))
    implementation(npm("opencv4nodejs-prebuilt", "5.3.3"))
}

kotlin {
    js(IR) {
        binaries.executable()
        nodejs {}
    }
}

plugins.withType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin> {
    configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
        nodeVersion = "15.11.0"
    }
}
