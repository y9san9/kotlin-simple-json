package parser

import ast.JsonInteger
import parser.base.Parser
import parser.base.charConsumer
import parser.base.takeWhile
import parser.dsl.parser

fun jsonIntegerParser(): Parser<JsonInteger> = parser {
    val minus = charConsumer('-')
        .tryParse()
        .map { "-" }
        .getOrElse { "" }

    val string = takeWhile { it.isDigit() }

    if (string.isEmpty()) fail()

    JsonInteger(string = "$minus$string")
}
