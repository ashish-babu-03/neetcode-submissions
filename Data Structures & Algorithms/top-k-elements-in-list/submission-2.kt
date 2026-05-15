class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        val freqMap = HashMap<Int, Int>()

        val result = mutableListOf<Int>()
        for (num in nums) freqMap[num] = (freqMap[num] ?: 0) + 1

        val tempBucket = Array(n + 1) { mutableListOf<Int>() }
        for ((num, freq) in freqMap) tempBucket[freq].add(num)
        
        for (i in tempBucket.size-1 downTo 0) {
            for (n in tempBucket[i]) {
                result.add(n)
                if (result.size == k) return result.toIntArray()
            }
        }

        return result.toIntArray()
    }
}
