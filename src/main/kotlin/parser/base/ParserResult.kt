package parser.base

sealed interface ParserResult<out T> {
    data class Success<out T>(val value: T, val remaining: String) : ParserResult<T>
    object Failure : ParserResult<Nothing> {
        override fun toString(): String = "Failure"
    }
}
