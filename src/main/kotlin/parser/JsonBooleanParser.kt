package parser

import ast.JsonBoolean
import ast.JsonFalse
import ast.JsonTrue
import parser.base.*

fun jsonBooleanParser(): Parser<JsonBoolean> = anyParser(jsonTrueParser(), jsonFalseParser())

fun jsonTrueParser(): Parser<JsonTrue> = stringConsumer("true").map { JsonTrue }
fun jsonFalseParser(): Parser<JsonFalse> = stringConsumer("false").map { JsonFalse }
