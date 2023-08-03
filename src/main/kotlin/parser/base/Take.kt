package parser.base

import parser.dsl.ParserState
import parser.dsl.discard
import parser.dsl.parser

fun takeExactParser(n: Int): Parser<String> = parser { takeExact(n) }

fun ParserState.takeExact(n: Int): String {
    val string = source.take(n)
    if (string.length != n) fail()
    discard(n)
    return string
}
