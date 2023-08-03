package parser.base

import parser.dsl.ParserState
import parser.dsl.discard
import parser.dsl.parser

fun charParser(char: Char): Parser<Char> = parser { char(char) }

fun charConsumer(char: Char): Consumer = charParser(char).consume()

fun ParserState.char(char: Char): Char {
    if (!source.startsWith(char)) fail()
    discard(n = 1)
    return char
}

fun Parser<Char>.string() = map { it.toString() }
