class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val numStringStack = ArrayDeque<String>()
        val exps = listOf("+","-", "*", "/")
        var result = 0
        for (i in tokens) {
            if(i !in exps) {
                numStringStack.add(i)
            } else {
                val int2 = numStringStack.removeLast().toInt()
                val int1 = numStringStack.removeLast().toInt()
                val result = when(i) {
                    "+" -> int1 + int2
                    "-" -> int1 - int2
                    "*" -> int1 * int2
                    "/" -> int1 / int2
                    else -> 0
                }
                numStringStack.add(result.toString())
            }
        }
        return numStringStack.removeLast().toInt()
    }
}
