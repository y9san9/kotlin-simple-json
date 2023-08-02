package parser

import ast.JsonArray
import parser.base.*
import parser.dsl.parser

fun jsonArrayParser(): Parser<JsonArray> = parser {
    char('[')
    whitespace()
    val nodes = manySeparated(
        elementParser = jsonNodeParser(failOnRemaining = false),
        separatorConsumer = commaConsumer()
    )
    whitespace()
    char(']')
    JsonArray(nodes)
}
