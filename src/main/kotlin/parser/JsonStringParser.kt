package parser

import ast.JsonString
import parser.base.Parser
import parser.base.char
import parser.base.takeWhile
import parser.dsl.ParserState
import parser.dsl.parser

// fixme: escaping is not supported
fun jsonStringParser(): Parser<JsonString> = parser {
    char('"')
    val string = takeWhile { char -> char != '"' }
    char('"')
    JsonString(string)
}

fun ParserState.jsonString(): JsonString = jsonStringParser().parse()
