package parser.base

import parser.dsl.ParserState
import parser.dsl.parser

fun <T> anyParser(vararg parsers: Parser<T>): Parser<T> = anyParser(parsers.toList())

fun <T> anyParser(list: List<Parser<T>>): Parser<T> = parser {
    for (parser in list) {
        parser
            .tryParse()
            .onSuccess { value -> return@parser value }
    }
    fail()
}

fun <T> ParserState.any(vararg parsers: Parser<T>): T = any(parsers.toList())
fun <T> ParserState.any(list: List<Parser<T>>): T = anyParser(list).parse()
