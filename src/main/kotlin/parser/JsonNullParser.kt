package parser

import ast.JsonNull
import parser.base.Parser
import parser.base.map
import parser.base.stringConsumer

fun jsonNullParser(): Parser<JsonNull> = stringConsumer(string = "null").map { JsonNull }
