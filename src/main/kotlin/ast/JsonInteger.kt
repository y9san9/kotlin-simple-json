package ast

// fixme: does not support floating points
data class JsonInteger(val string: String) : JsonPrimitive {
    val byte: Byte get() = string.toByte()
    val short: Short get() = string.toShort()
    val int: Int get() = string.toInt()
    val long: Long get() = string.toLong()
}
