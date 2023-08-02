package parser

import ast.JsonInteger
import parser.base.*
import parser.dsl.parser

fun jsonIntegerParser(): Parser<JsonInteger> = parser {
    val minus = stringParser(string = "-")
        .tryParse()
        .getOrNull()
        ?: ""

    val string = takeWhile(Char::isDigit)

    if (string.isEmpty()) fail()

    JsonInteger(string = "$minus$string")
}
