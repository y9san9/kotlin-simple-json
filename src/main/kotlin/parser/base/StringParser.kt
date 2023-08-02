package parser.base

import parser.dsl.ParserState
import parser.dsl.discard
import parser.dsl.parser

fun stringParser(string: String): Parser<String> = parser {
    if (!source.startsWith(string)) fail()
    discard(string.length)
    string
}

fun stringConsumer(string: String): Consumer = stringParser(string).consume()

fun ParserState.string(string: String): String = stringParser(string).parse()
