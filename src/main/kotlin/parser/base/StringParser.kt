package parser.base

import parser.dsl.ParserState
import parser.dsl.discard
import parser.dsl.parser

fun stringParser(string: String): Parser<String> = parser { string(string) }

fun stringConsumer(string: String): Consumer = stringParser(string).consume()

fun ParserState.string(string: String): String {
    if (!source.startsWith(string)) fail()
    discard(string.length)
    return string
}
