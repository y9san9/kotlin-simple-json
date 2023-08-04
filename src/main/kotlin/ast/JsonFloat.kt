package ast

data class JsonFloat(val string: String) : JsonPrimitive {
    val float: Float get() = string.toFloat()
    val double: Double get() = string.toDouble()

    val floatOrNull: Float? get() = string.toFloatOrNull()
    val doubleOrNull: Double? get() = string.toDoubleOrNull()
}
