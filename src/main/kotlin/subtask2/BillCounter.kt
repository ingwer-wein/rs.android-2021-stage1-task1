package subtask2

class BillCounter {
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val rest = b - (bill.sum() - bill[k]) / 2
        return if (rest == 0) "Bon Appetit" else rest.toString()
    }
}