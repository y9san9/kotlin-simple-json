package parser.base

import parser.dsl.ParserState
import parser.dsl.discard
import parser.dsl.parser

fun charConsumer(char: Char): Consumer = parser {
    if (!source.startsWith(char)) fail()
    discard(n = 1)
}

fun ParserState.char(char: Char) {
    charConsumer(char).parse()
}
