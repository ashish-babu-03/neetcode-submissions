class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var n1 = matrix.size
        var n2 = matrix[0].size 
        var x1 = 0
        var x2 = n1 - 1
        while (x1 <= x2) {
            val midX = (x1+x2)/2
            when {
                matrix[midX][0] <= target && target <= matrix[midX][n2 - 1] -> {
                    var targetMatrix = matrix[midX]
                    var y1 = 0
                    var y2 = n2 - 1
                    while (y1 <= y2) {
                        val midY = (y1+y2)/2
                        when {
                            targetMatrix[midY] == target -> return true
                            targetMatrix[midY] < target -> y1 = midY + 1
                            targetMatrix[midY] > target -> y2 = midY - 1
                        }
                    }
                    return false
                }
                matrix[midX][0] < target -> x1 = midX + 1
                matrix[midX][0] > target -> x2 = midX - 1
            }
        }
        return false
    }
}
