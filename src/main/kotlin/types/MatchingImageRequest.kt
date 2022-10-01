package types

data class MatchingImageRequest(
  val baseConfidence: Double = 0.88,
  val lowerConfidenceWhenFail: Double = -0.022,
  val timeoutMs: Int = 2000,
  val intervalMs: Int = 500,
  val maxRetry: Int = 5,
  val detectInRegion: PredefinedRegion? = null,
)
