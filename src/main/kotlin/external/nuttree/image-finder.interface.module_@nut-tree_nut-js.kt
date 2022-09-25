@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

import kotlin.js.Promise

external interface ImageFinderInterface {
    fun findMatch(matchRequest: MatchRequest): Promise<MatchResult>
    fun findMatches(matchRequest: MatchRequest): Promise<Array<MatchResult>>
}
