class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var p1 = 0
        var p2 = numbers.size -1
        while (p1 < p2) {
            if (numbers[p1] + numbers[p2] > target) {
                println(""+numbers[p1]+" "+numbers[p2])
                p2--
            }
            else if (numbers[p1] + numbers[p2] < target) {
                p1++
            } else {
                return intArrayOf(p1+1, p2+1)
            }
        }
        return intArrayOf()

    }
}
