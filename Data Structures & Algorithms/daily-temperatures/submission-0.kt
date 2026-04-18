class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = ArrayDeque<Int>()
        val result = IntArray(temperatures.size)
        for (i in temperatures.indices) {
            while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.last()]) {
                val latestIndex = stack.removeLast()
                result[latestIndex]= i - latestIndex
            }

            stack.add(i)
        }
        return result
    }
}
