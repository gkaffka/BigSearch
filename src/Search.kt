class Search {
    fun search(query: String) {
        val map = buildBookHash(book)
        val splitQuery = query.split(" ")
        if (splitQuery.size == 1) {
            printResult(query, map[splitQuery[0]]?.toList())
            return
        }
        val nodes = splitQuery.map { map[it] }
        val startPositions = getStartPositions(splitQuery, nodes)
        printResult(query, startPositions)
    }

    private fun buildBookHash(book: String): HashMap<String, MutableList<Int>?> {
        val map = HashMap<String, MutableList<Int>?>()
        book.split(" ").forEachIndexed { index, s ->
            map[s] = if (map[s] == null) mutableListOf<Int>().apply { this.add(index) }
            else map[s].apply { this?.add(index) }
        }
        return map
    }

    private fun getStartPositions(splitQuery: List<String>, nodes: List<List<Int>?>) =
        mutableListOf<Int>().apply {
            var nodeProbe = 0;
            nodes.first()?.forEach { position ->
                nodes.forEachIndexed { depth, link ->
                    if (link?.contains(position + depth) == true) nodeProbe++
                    else nodeProbe = 0
                    return@forEachIndexed
                }
                if (nodeProbe == splitQuery.size) {
                    this.add(position)
                    nodeProbe = 0
                }
            }
        }

    private fun printResult(text: String, startPositions: List<Int>?) {
        if (startPositions.isNullOrEmpty()) {
            print("Sorry, I could not find the \"$text\" text in the book")
            return
        }
        println("I found ${startPositions.size} ocurrencies for \"$text\"")
        println("These are the occurrence locations in the text \n$startPositions")
    }
}
