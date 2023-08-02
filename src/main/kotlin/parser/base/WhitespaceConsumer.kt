package parser.base

import parser.dsl.ParserState

fun whitespaceConsumer(): Consumer = takeWhileParser { it.isWhitespace() }.consume()

fun ParserState.whitespace() {
    whitespaceConsumer().parse()
}
