package parser

import ast.JsonPrimitive
import parser.base.Parser
import parser.base.anyParser

fun jsonPrimitiveParser(): Parser<JsonPrimitive> = anyParser(
    jsonNullParser(),
    jsonBooleanParser(),
    jsonFloatParser(),
    jsonIntegerParser(),
    jsonStringParser()
)
