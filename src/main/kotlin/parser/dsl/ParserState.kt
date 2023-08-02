package parser.dsl

import parser.base.Parser
import parser.base.ParserResult

private class ParserFailure : RuntimeException()

class ParserState(
    var source: String
) {
    fun <T> Parser<T>.parse(): T =
        when (val result = parse(source)) {
            ParserResult.Failure -> fail()
            is ParserResult.Success -> {
                source = result.remaining
                result.value
            }
        }

    fun <T> Parser<T>.tryParse(): Result<T> {
        return try {
            val value = parse()
            Result.success(value)
        } catch (failure: ParserFailure) {
            Result.failure(failure)
        }
    }

    fun fail(): Nothing = throw ParserFailure()
}

fun <T> parser(block: ParserState.() -> T): Parser<T> = Parser { source ->
    try {
        val state = ParserState(source)
        val result = state.block()
        ParserResult.Success(result, state.source)
    } catch (_: ParserFailure) {
        ParserResult.Failure
    }
}
