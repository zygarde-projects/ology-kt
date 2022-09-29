package extension

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject

fun primitiveHashMap(content: dynamic): Map<String, dynamic> {
  val json = Json.parseToJsonElement(JSON.stringify(content))
  return json.jsonObject.toMap()
}
