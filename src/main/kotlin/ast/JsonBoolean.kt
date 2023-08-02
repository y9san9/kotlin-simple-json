package ast

sealed interface JsonBoolean : JsonPrimitive {
    val boolean: Boolean
}

object JsonTrue : JsonBoolean {
    override val boolean = true
    override fun toString(): String = "JsonTrue"
}

object JsonFalse : JsonBoolean {
    override val boolean = false
    override fun toString(): String = "JsonFalse"
}
