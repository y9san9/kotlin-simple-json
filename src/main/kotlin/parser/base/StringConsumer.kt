package parser.base

import parser.dsl.ParserState
import parser.dsl.discard
import parser.dsl.parser

fun stringConsumer(string: String): Consumer = parser {
    if (!source.startsWith(string)) fail()
    discard(string.length)
}

fun ParserState.string(string: String) {
    stringConsumer(string).parse()
}
