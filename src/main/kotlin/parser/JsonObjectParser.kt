package parser

import ast.JsonNode
import ast.JsonObject
import parser.base.*
import parser.dsl.parser

fun jsonObjectParser(): Parser<JsonObject> = parser {
    char('{')
    whitespace()
    val pairs = manySeparated(
        elementParser = pairParser(),
        separatorConsumer = commaConsumer()
    )
    whitespace()
    char('}')

    JsonObject(pairs.toMap())
}

private fun pairParser(): Parser<Pair<String, JsonNode>> = parser {
    val key = jsonString()
    whitespace()
    char(':')
    whitespace()
    val node = jsonNode()
    key.string to node
}
