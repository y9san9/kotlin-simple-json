package parser

import ast.JsonNode
import parser.base.Parser
import parser.base.any
import parser.dsl.ParserState
import parser.dsl.parser

fun jsonNodeParser(failOnRemaining: Boolean = true): Parser<JsonNode> = parser {
    val result = any(
        jsonPrimitiveParser(),
        jsonArrayParser(),
        jsonObjectParser()
    )
    if (failOnRemaining && source.isNotEmpty()) fail()
    result
}

fun ParserState.jsonNode(): JsonNode = jsonNodeParser(failOnRemaining = false).parse()
