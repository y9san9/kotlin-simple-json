package parser

import ast.JsonString
import parser.base.*
import parser.dsl.ParserState
import parser.dsl.parser

fun jsonStringParser(): Parser<JsonString> = parser {
    char('"')
    val string = many(
        anyParser(
            unescapedString(),
            specialCharacters()
        )
    ).joinToString(separator = "")
    char('"')
    JsonString(string)
}

private fun unescapedString(): Parser<String> = parser {
    takeWhile { char -> char != '"' && char != '\\' }
        .takeIf { it.isNotEmpty() }
        ?: fail()
}

private fun specialCharacters(): Parser<String> = parser {
    char('\\')

    any(
        charParser('\"').string(),
        charParser('\\').string(),
        charParser('/').string(),
        charParser('b').map { "\b" },
        charParser('f').map { "\u000c" },
        charParser('n').map { "\n" },
        charParser('r').map { "\r" },
        charParser('t').map { "\t" },
        unicodeCharacter().string()
    )
}

private fun unicodeCharacter(): Parser<Char> = parser {
    char('u')
    val code = takeExact(n = 4)
        .toIntOrNull(radix = 16)
        ?: fail()
    Char(code)
}

fun ParserState.jsonString(): JsonString = jsonStringParser().parse()
