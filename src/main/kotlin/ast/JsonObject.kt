package ast

data class JsonObject(val map: Map<String, JsonNode>) : JsonNode
