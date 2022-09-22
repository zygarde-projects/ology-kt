plugins {
    kotlin("js") version "1.6.21"
    kotlin("plugin.serialization") version "1.6.21"
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
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")

    implementation(npm("@nut-tree/nut-js", "next"))
    implementation(npm("@nut-tree/template-matcher", "next"))
    implementation(npm("ws", "8.8.1"))
    implementation(npm("yargs", "17.5.1"))
    implementation(npm("@types/yargs", "17.0.2", generateExternals = false))
}

kotlin {
    js(LEGACY) { // The serialization will be broken by IR
        binaries.executable()
        nodejs {
            runTask {
                args("host", "-f=abc") // host command
//                args("client", "-h=localhost") // client command
            }
        }
        compilations["main"].packageJson {
            customField("bin", mapOf("ology" to "kotlin/ology-kt.js"))
            customField("types", "kotlin/ology-kt.d.ts")
            customField("scripts", mapOf("ology" to "chmod 755 kotlin/ology-kt.js && node kotlin/ology-kt.js")) // for testing
        }
    }
}

plugins.withType<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin> {
    the<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension>().ignoreScripts = false
}
