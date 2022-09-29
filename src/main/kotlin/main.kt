import command.*
import external.nuttree.LoadMatcher
import external.yargs.yargs

fun main() {
  LoadMatcher
  println(greeting("ology-kt"))
  yargs.usage("Usage: $0 <command> [options]")
    .command(HostCommand)
    .command(ClientCommand)
    .command(GenerateDefaultConfigCommand)
    .command(TestCommand)
    .command(NgCommand)
    .command(ExitGameCommand)
    .command(DevCommand)
    .command(JoinGameCommand)
    .command(BoCommand)
    .recommendCommands()
    .demandCommand(1)
    .strict()
    .argv
}

fun greeting(name: String) =
  "Hello, $name"
