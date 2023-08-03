package parser.base

import parser.dsl.ParserState
import parser.dsl.parser

fun <T> manySeparatedParser(
    elementParser: Parser<T>,
    separatorConsumer: Consumer
): Parser<List<T>> = parser {
    manySeparated(elementParser, separatorConsumer)
}

fun <T> ParserState.manySeparated(
    elementParser: Parser<T>,
    separatorConsumer: Consumer
): List<T> {
    val first = elementParser.tryParse().getOrElse { return emptyList() }

    val elementWithSeparator = parser {
        separatorConsumer.parse()
        elementParser.parse()
    }

    return listOf(first) + many(elementWithSeparator)
}
