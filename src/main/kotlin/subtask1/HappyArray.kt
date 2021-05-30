package subtask1

class HappyArray {
    fun convertToHappy(sadArray: IntArray): IntArray {
        if (sadArray.isEmpty()) return sadArray
        val buffer = sadArray.toMutableList()
        val happyList = emptyList<Int>().toMutableList()

        var isHappy: Boolean
        do {
            happyList += sadArray.first()
            isHappy = true

            for (i in 0 until buffer.lastIndex - 1) {
                if (buffer[i + 1] < buffer[i] + buffer[i + 2]) {
                    happyList += buffer[i + 1]
                } else isHappy = false
            }
            happyList += sadArray.last()

            buffer.clear()

            if (!isHappy) {
                buffer += happyList
                happyList.clear()
            }
        } while (!isHappy)
        return happyList.toIntArray()
    }
}