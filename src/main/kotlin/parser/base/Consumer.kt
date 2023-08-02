package parser.base

typealias Consumer = Parser<Unit>

fun Parser<*>.consume(): Consumer = map { }
