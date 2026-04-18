class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        var time = 0
        val directions = listOf(Pair(0,1), Pair(0,-1), Pair(1,0), Pair(-1,0))
        val queue = ArrayDeque<Pair<Int,Int>>()
        val rows = grid.size
        val cols = grid[0].size
        var freshOrangesCount = 0
        for (i in 0..rows-1) {
            for (j in 0..cols-1) {
                if(grid[i][j] == 2) queue.add(Pair(i, j))
                if(grid[i][j] == 1) freshOrangesCount++
            }
        }

        while (queue.isNotEmpty()) {
            val level = queue.size
            var isRottenNextLevel = false
            repeat (level) {
                val (rr, rc) = queue.removeFirst()
                for ((r, c) in directions) {
                    val newRow = rr+r
                    val newCol = rc+c

                    if (newRow < 0 || newRow >= rows) continue
                    if (newCol < 0 || newCol >= cols) continue
                    if (grid[newRow][newCol] != 1) continue

                    grid[newRow][newCol] = 2
                    queue.addLast(Pair(newRow, newCol))
                    freshOrangesCount--
                    isRottenNextLevel = true
                }
            }

            if (isRottenNextLevel) time++
        }
        return if (freshOrangesCount > 0) -1 else time
        
    }
}
