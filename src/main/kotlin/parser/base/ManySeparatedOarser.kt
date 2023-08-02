package parser.base

import parser.dsl.ParserState
import parser.dsl.parser

fun <T> manySeparatedParser(
    elementParser: Parser<T>,
    separatorConsumer: Consumer
): Parser<List<T>> = parser {
    val first = elementParser.tryParse().getOrElse { return@parser emptyList() }

    val elementWithSeparator = parser {
        separatorConsumer.parse()
        elementParser.parse()
    }

    listOf(first) + many(elementWithSeparator)
}

fun <T> ParserState.manySeparated(
    elementParser: Parser<T>,
    separatorConsumer: Consumer
): List<T> = manySeparatedParser(elementParser, separatorConsumer).parse()
