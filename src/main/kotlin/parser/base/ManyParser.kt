@file:Suppress("UNREACHABLE_CODE")

package parser.base

import parser.dsl.ParserState
import parser.dsl.parser

fun <T> manyParser(elementParser: Parser<T>): Parser<List<T>> = parser {
    val results: MutableList<T> = mutableListOf()

    while (true) {
        val result = elementParser
            .tryParse()
            .getOrElse { return@parser results }

        results += result
    }

    fail()
}

fun <T> ParserState.many(elementParser: Parser<T>): List<T> = manyParser(elementParser).parse()
