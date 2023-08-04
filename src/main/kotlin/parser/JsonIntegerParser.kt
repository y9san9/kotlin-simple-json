package parser

import ast.JsonInteger
import parser.base.Parser
import parser.base.takeFirst
import parser.base.takeWhile
import parser.dsl.parser

fun jsonIntegerParser(): Parser<JsonInteger> = parser {
    val minus = takeFirst { it == '-' }
    val string = takeWhile(Char::isDigit)

    if (string.isEmpty()) fail()

    JsonInteger(string = "$minus$string")
}
