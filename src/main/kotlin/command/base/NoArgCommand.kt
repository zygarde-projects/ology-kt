package command.base

abstract class NoArgCommand(command: String) : BaseCommand<Unit>(command) {
  override suspend fun handle(args: Unit) {
    handle()
  }

  abstract suspend fun handle()
}
