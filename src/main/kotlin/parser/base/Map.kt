package parser.base

inline fun <T, R> ParserResult<T>.map(transform: (T) -> R): ParserResult<R> =
    when (this) {
        ParserResult.Failure -> ParserResult.Failure
        is ParserResult.Success -> ParserResult.Success(transform(value), remaining)
    }

inline fun <T, R> Parser<T>.map(
    crossinline transform: (T) -> R
): Parser<R> = Parser { source ->
    val result = parse(source)
    result.map(transform)
}
