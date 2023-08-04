package parser.base

import parser.dsl.ParserState
import parser.dsl.discard
import parser.dsl.parser

inline fun takeFirstParser(
    crossinline predicate: (Char) -> Boolean
): Parser<String> = parser { takeFirst(predicate) }

inline fun ParserState.takeFirst(
    predicate: (Char) -> Boolean
): String {
    val result = source.firstOrNull() ?: return ""
    if (predicate(result)) {
        discard(1)
        return result.toString()
    }
    return ""
}
