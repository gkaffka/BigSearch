class Search {
    fun search(text: String) {
        val map = HashMap<String, MutableList<Int>?>()
        val splitText = text.split(" ")
        book.split(" ").forEachIndexed { index, s ->
            map[s] = if (map[s] == null) mutableListOf<Int>().apply { this.add(index) }
            else map[s].apply { this?.add(index) }
        }

        if (splitText.size == 1) {
            println(map[splitText[0]])
            return
        }

        val validStartPosition = mutableListOf<Int>()
        val nodes = splitText.map { map[it] }

        nodes.forEachIndexed { iNode, node ->
            node?.forEach { position ->
                if (iNode + 1 >= nodes.size) return@forEachIndexed
                nodes[iNode + 1]?.forEach { positionNext ->
                    if ((positionNext - position) == 1) {
                        validStartPosition.add(position)
                    }
                }
            }
        }
        validStartPosition.sort()

        if (validStartPosition.isNullOrEmpty()) {
            print("Sorry, not found")
            return
        }

        //Indicates the word position in the text
        val startPositions = validStartPosition
            .chunked(splitText.size - 1)
            .map { it.first() }


        println(startPositions)
    }


}