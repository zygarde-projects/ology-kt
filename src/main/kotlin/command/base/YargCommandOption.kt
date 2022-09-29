package command.base

import external.yargs.Options

data class YargCommandOption(
  val key: String,
  override var alias: String,
  override var demandOption: Boolean,
  override var description: String? = null,
) : Options
