class Solution {
    fun climbStairs(n: Int): Int {
        var n1 = 0
        var n2 = 1
        var result = n2
        for (i in 1..n) {
            result = n1+n2
            n1 = n2
            n2 = result
        }
        return result
    }
}
