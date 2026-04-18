class Solution {
    var count = 0
    fun numIslands(grid: Array<CharArray>): Int {
        for (row in grid.indices) {
            for (col in grid[0].indices) {
                if (grid[row][col] == '1') {
                    count ++
                    dfs(grid, row, col)
                }
            }
        }
        return count
    }

    fun dfs(grid: Array<CharArray>, i: Int, j: Int) {
        if ( i < 0 || i >= grid.size || j < 0 || j >= grid[0].size || grid[i][j] == '0' ) return
        grid[i][j] = '0'
        dfs(grid, i -1, j)
        dfs (grid, i +1, j)
        dfs(grid, i,j-1)
        dfs(grid, i, j+1)
    }
}
