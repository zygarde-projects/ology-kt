package command.base

abstract class NoArgCommand(command: String) : BaseCommand<Unit>(command) {
    override fun handle(args: Unit) {
        handle()
    }

    abstract fun handle()
}
