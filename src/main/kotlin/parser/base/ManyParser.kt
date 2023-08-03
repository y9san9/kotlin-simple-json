package parser.base

import parser.dsl.ParserState
import parser.dsl.parser

fun <T> manyParser(elementParser: Parser<T>): Parser<List<T>> = parser { many(elementParser) }

fun <T> ParserState.many(elementParser: Parser<T>): List<T> {
    val results: MutableList<T> = mutableListOf()

    while (true) {
        val result = elementParser
            .tryParse()
            .getOrElse { return results }

        results += result
    }
}
