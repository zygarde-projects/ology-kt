import external.nuttree.LoadMatcher
import external.nuttree.Screen
import external.nuttree.imageResource
import external.yargs.yargs

fun main() {
    println(greeting("ology-kt"))
    yargs.usage("Usage: $0 <command> [options]")
        .recommendCommands()
        .demandCommand(1)
        .strict()
        .help("h")
        .alias("h", "help")
        .argv
    LoadMatcher
    Screen.find(imageResource("kotlin/template/act4wp.png"), null)
        .then { println(it) }
        .catch { println("can't find act4wp") }
}

fun greeting(name: String) =
    "Hello, $name"
