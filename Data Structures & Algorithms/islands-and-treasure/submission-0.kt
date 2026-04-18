class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
        val directions = listOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))
        val rows = grid.size
        val cols = grid[0].size
        val queue = ArrayDeque<Pair<Int,Int>>()
        for (i in 0..rows-1) {
            for (j in 0..cols-1) {
                if (grid[i][j] == 0) 
                    queue.add(Pair(i, j))
            }
        }

        while (queue.isNotEmpty()) {
            val (cr, cc) = queue.removeFirst()
            for ((r, c) in directions) {
                val newRow = r+cr
                val newCol = c+cc
                if (newRow < 0 || newRow >= rows) continue
                if (newCol < 0 || newCol >= cols) continue
                if (grid[newRow][newCol] != Int.MAX_VALUE) continue

                if (grid[newRow][newCol] == -1) continue
                grid[newRow][newCol] = grid[cr][cc] + 1
                queue.add(Pair(newRow, newCol))
            }
        }
    }
}
