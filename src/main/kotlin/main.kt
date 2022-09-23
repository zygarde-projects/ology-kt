import command.ClientCommand
import command.GenerateDefaultConfigCommand
import command.HostCommand
import external.yargs.yargs

fun main() {
    println(greeting("ology-kt"))
    yargs.usage("Usage: $0 <command> [options]")
        .command(HostCommand())
        .command(ClientCommand())
        .command(GenerateDefaultConfigCommand())
        .recommendCommands()
        .demandCommand(1)
        .strict()
        .argv
}

fun greeting(name: String) =
    "Hello, $name"
