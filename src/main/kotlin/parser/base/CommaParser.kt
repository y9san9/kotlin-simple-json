package parser.base

import parser.dsl.ParserState
import parser.dsl.parser

fun commaConsumer(): Consumer = parser { comma() }

fun ParserState.comma() {
    whitespace()
    char(',')
    whitespace()
}
