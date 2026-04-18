class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var max = 0
        for (row in grid.indices) {
            for (col in grid[0].indices) {
                if (grid[row][col] == 1) {
                    max = max(max, dfs(grid, row, col))
                }
            }
        }
        return max
    }

    fun dfs(grid: Array<IntArray>, row: Int, col: Int): Int {
        if (row < 0 || row >= grid.size || col < 0 || col >= grid[0].size) return 0
        if (grid[row][col] == 0) return 0
        grid[row][col] = 0
        return 1 +
        dfs(grid, row+1, col) + dfs(grid, row - 1,col) + 
        dfs(grid, row, col +1) + dfs(grid, row, col -1)
    }
}
