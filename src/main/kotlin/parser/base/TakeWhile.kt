package parser.base

import parser.dsl.ParserState
import parser.dsl.discard
import parser.dsl.parser

inline fun takeWhileParser(
    crossinline predicate: (Char) -> Boolean
): Parser<String> = parser { takeWhile(predicate) }

inline fun ParserState.takeWhile(
    predicate: (Char) -> Boolean
): String {
    val result = source.takeWhile(predicate)
    discard(result.length)
    return result
}
