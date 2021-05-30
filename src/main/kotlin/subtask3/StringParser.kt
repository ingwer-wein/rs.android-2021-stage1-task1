package subtask3

class StringParser {
    fun getResult(inputString: String): Array<String> {
        val templatesWide = listOf("(?=\\<)(?:(?=.*?\\<(?!.*?\\1)(.*\\>(?!.*\\2).*))(?=.*?\\>(?!.*?\\2)(.*)).)+?.*?(?=\\1)[^\\<]*(?=\\2\$)",
        "(?=\\[)(?:(?=.*?\\[(?!.*?\\1)(.*\\](?!.*\\2).*))(?=.*?\\](?!.*?\\2)(.*)).)+?.*?(?=\\1)[^\\[]*(?=\\2\$)",
        "(?=\\()(?:(?=.*?\\((?!.*?\\1)(.*\\)(?!.*\\2).*))(?=.*?\\)(?!.*?\\2)(.*)).)+?.*?(?=\\1)[^\\(]*(?=\\2\$)")
        val subStrings = emptyList<String>().toMutableList()
        var idx = 0
        inputString.withIndex().forEach { (i,l) ->
            when (l) {
                '<' -> { idx = 0 }
                '[' -> { idx = 1 }
                '(' -> { idx = 2 }
            }
            val match = templatesWide[idx].toRegex().find(inputString.substring(if (i == 0) 0 else i - 1))
            subStrings += match?.value?.drop(1)?.dropLast(1) ?: ""
        }
        return subStrings.distinct().filter{ it.isNotEmpty() }.toTypedArray()
    }
}
