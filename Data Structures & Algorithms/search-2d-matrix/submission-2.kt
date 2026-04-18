class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var l = 0
        val m = matrix.size
        val n = matrix[0].size
        var r = n * m - 1
        while (l<=r) {
            val mid = (l+r)/2
            val midElement = matrix[mid/n][mid%n]
            if (midElement == target) return true
            else if (midElement < target) l = mid+1
            else r = mid - 1
        }
        return false
    }
}
