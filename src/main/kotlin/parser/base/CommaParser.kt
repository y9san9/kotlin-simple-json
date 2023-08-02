package parser.base

import parser.dsl.ParserState
import parser.dsl.parser

fun commaConsumer(): Consumer = parser {
    whitespace()
    char(',')
    whitespace()
}

fun ParserState.comma() = commaConsumer().parse()
