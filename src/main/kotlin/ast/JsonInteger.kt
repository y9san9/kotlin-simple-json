package ast

data class JsonInteger(val string: String) : JsonPrimitive {
    val byte: Byte get() = string.toByte()
    val short: Short get() = string.toShort()
    val int: Int get() = string.toInt()
    val long: Long get() = string.toLong()

    val byteOrNull: Byte? get() = string.toByteOrNull()
    val shortOrNull: Short? get() = string.toShortOrNull()
    val intOrNull: Int? get() = string.toIntOrNull()
    val longOrNull: Long? get() = string.toLongOrNull()
}
