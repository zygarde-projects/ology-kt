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
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.6.4")

    implementation(npm("@nut-tree/nut-js", "next"))
    implementation(npm("@nut-tree/template-matcher", "next"))
    implementation(optionalNpm("@zygarde-projects/win-control", "0.3.1"))
    implementation(npm("nconf", "0.12.0"))
    implementation(npm("ws", "8.8.1"))
    implementation(npm("yargs", "17.5.1"))
    implementation(npm("@types/nconf", "0.10.3", generateExternals = true))
}

kotlin {
    js(LEGACY) { // The serialization will be broken by IR
        binaries.executable()
        nodejs {
            runTask {
                args("config-gen")
//                args("host", "-c=${rootProject.file("config").absolutePath}/config.json") // host command
//                args("client", "-c=${rootProject.file("config").absolutePath}/config.json") // client command
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

task("prepareBinJs") {
    doLast {
        val projectName = project.name
        val binText = "#!/usr/bin/env node"
        File(project.buildDir, "js/packages/$projectName/kotlin/$projectName.js")
            .also {
                val content = it.readText()
                if (!content.startsWith(binText)) {
                    it.writeText(
                        """$binText
${it.readText()}"""
                    )
                }
            }
    }
}

task("packResources", Exec::class) {
    commandLine = listOf("cp", "-r", "src/main/resources", "build/js/packages/ology-kt/resources")
}

tasks.getByName("compileKotlinJs").finalizedBy("prepareBinJs", "packResources")
