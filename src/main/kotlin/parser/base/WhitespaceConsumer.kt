package parser.base

import parser.dsl.ParserState
import parser.dsl.parser

fun whitespaceConsumer(): Consumer = parser { whitespace() }

fun ParserState.whitespace() {
    takeWhile { it.isWhitespace() }
}
