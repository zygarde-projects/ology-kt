package types

import external.nuttree.Region

data class MatchedImage(
  val image: String,
  val region: Region?,
)
