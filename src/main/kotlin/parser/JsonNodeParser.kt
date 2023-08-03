package parser

import ast.JsonNode
import parser.base.Parser
import parser.base.any
import parser.dsl.ParserState
import parser.dsl.parser

fun jsonNodeParser(failOnRemaining: Boolean = true): Parser<JsonNode> = parser {
    val node = jsonNode()
    if (failOnRemaining && source.isNotEmpty()) fail()
    node
}

fun ParserState.jsonNode(): JsonNode = any(
    jsonPrimitiveParser(),
    jsonArrayParser(),
    jsonObjectParser()
)
