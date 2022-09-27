package types

data class MatchingImageRequest(
    val baseConfidence: Double = 0.9,
    val lowerConfidenceWhenFail: Double = -0.025,
    val timeoutMs: Int = 3000,
    val intervalMs: Int = 500,
    val maxRetry: Int = 5,
    val detectInRegion: PredefinedRegion? = null,
)
