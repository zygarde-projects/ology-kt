import command.*
import external.nconf.nconf
import external.nuttree.LoadMatcher
import external.yargs.yargs

fun main() {
  val version = nconf.file("$__dirname/../package.json").get("version")
  println("Ology verison:$version")
  LoadMatcher
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
