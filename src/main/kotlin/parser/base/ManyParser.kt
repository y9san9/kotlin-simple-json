@file:Suppress("UNREACHABLE_CODE")

package parser.base

import parser.dsl.ParserState
import parser.dsl.parser

fun <T> manyParser(
    elementParser: Parser<T>,
    separatorConsumer: Consumer
): Parser<List<T>> = parser {
    val first = elementParser.tryParse().getOrElse { return@parser emptyList() }

    val results: MutableList<T> = mutableListOf(first)

    while (true) {
        runCatching {
            separatorConsumer.parse()
            elementParser.parse()
        }.onSuccess { result ->
            results += result
        }.onFailure {
            return@parser results
        }
    }

    fail()
}

fun <T> ParserState.many(
    elementParser: Parser<T>,
    separatorConsumer: Consumer
): List<T> = manyParser(elementParser, separatorConsumer).parse()
