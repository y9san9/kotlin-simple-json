import ast.JsonNode
import parser.base.Parser
import parser.jsonNodeParser

// Note:
// Does not support:
// - Escaping
// - Floating point
// - Error reporting

fun main() {
    val parser: Parser<JsonNode> = jsonNodeParser()

    val exampleJson = """
        {
            "glossary": {
                "title": "example glossary",
                "pages": 1,
                "description": null,
                "GlossDiv": {
                    "id": -1,
                    "title": "S",
                    "GlossList": {
                        "GlossEntry": {
                            "ID": "SGML",
                            "SortAs": "SGML",
                            "GlossTerm": "Standard Generalized Markup Language",
                            "Acronym": "SGML",
                            "Abbrev": "ISO 8879:1986",
                            "GlossDef": {
                                "para": "A meta-markup language, used to create markup languages such as DocBook.",
                                "GlossSeeAlso": [
                                    "GML",
                                    "XML"
                                ]
                            },
                            "GlossSee": "markup"
                        }
                    }
                }
            }
        }
    """.trimIndent()

    println(
        parser.parse(exampleJson)
    )

    println(
        parser.parse("12456, 567890")
    )
    println(
        parser.parse("\"Test")
    )
    println(
        parser.parse("")
    )
    println(
        parser.parse("nul")
    )
}
