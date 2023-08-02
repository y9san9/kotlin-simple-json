package parser.base

import parser.dsl.ParserState
import parser.dsl.discard
import parser.dsl.parser

fun charParser(char: Char): Parser<Char> = parser {
    if (!source.startsWith(char)) fail()
    discard(n = 1)
    char
}

fun charConsumer(char: Char): Consumer = charParser(char).consume()

fun ParserState.char(char: Char): Char = charParser(char).parse()
