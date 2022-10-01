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
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.6.4")

  implementation(npm("@nut-tree/nut-js", "next"))
  implementation(npm("@nut-tree/template-matcher", "next"))
  implementation(npm("cors", "2.8.5"))
  implementation(npm("express", "4.18.1"))
  implementation(npm("nconf", "0.12.0"))
  implementation(npm("os", "0.1.2"))
  implementation(npm("ws", "8.8.1"))
  implementation(npm("reconnecting-websocket", "4.4.0"))
  implementation(npm("yargs", "17.5.1"))
  implementation(npm("@types/nconf", "0.10.3"))
  implementation(npm("@types/node", "16.11.7"))
}

kotlin {

  js(LEGACY) { // The serialization will be broken by IR
    binaries.executable()
    nodejs {
      runTask {
//        args("test")
//        args("action", "-a=FindAndEnterTp")
//        args("dev", "detect-all")
//        args("dev", "mouse-tracking")
//        args("bo")
//        args("ip")
//args("join", "-n=sally01", "-p=a")
//        args("config-gen")
        args("host") // host command
//        args("client") // client command
      }
    }
    compilations["main"].packageJson {
      customField("bin", mapOf("ology" to "kotlin/ology-kt.js"))
      customField("types", "kotlin/ology-kt.d.ts")
      customField("scripts", mapOf("ology" to "chmod 755 kotlin/ology-kt.js && node kotlin/ology-kt.js")) // for testing
    }
  }
}

val runningWindows = System.getProperty("os.name").startsWith("Windows")
val runningCI = System.getenv("CI") != null

plugins.withType<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin> {
  the<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension>().ignoreScripts = runningCI
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

task("packResources", Copy::class) {
  from("src/main/resources")
  into("build/js/packages/ology-kt/resources")
  from("web/dist")
  into("build/js/packages/ology-kt/resources/dist")
}

task("packTestResources", Copy::class) {
  from("src/main/resources")
  into("build/js/packages/ology-kt-test/resources")
}

task("prepareDevNodeModules", Copy::class) {
  from("dev-assets/${if (runningWindows) "windows" else "non-windows"}/node_modules")
  into("node_modules")
}

tasks.getByName("compileKotlinJs").finalizedBy("packResources")
tasks.getByName("build").finalizedBy("prepareBinJs")
tasks.getByName("nodeTest").dependsOn("packTestResources")
