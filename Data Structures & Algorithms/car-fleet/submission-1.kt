class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = ArrayDeque<Int>()
        val result = IntArray(temperatures.size)
        for (i in temperatures.indices) {
            while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.last()]) {
                val lastIndex = stack.removeLast()
                result[lastIndex] = i - lastIndex
            }

            stack.add(i)
        }

        return result
    } 
}
