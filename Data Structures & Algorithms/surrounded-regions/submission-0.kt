class Solution {
    fun solve(board: Array<CharArray>) {
        val directions = listOf(Pair(1,0), Pair(-1,0), Pair(0,1), Pair(0,-1))
        val queue = ArrayDeque<Pair<Int, Int>>()
        val rows = board.size
        val cols = board[0].size
        for (i in 0..rows-1) {
            if (board[i][0] == 'O') queue.add(Pair(i, 0))
            if (board[i][cols-1] == 'O') queue.add(Pair(i, cols-1))
        }
        for (i in 0..cols-1) {
            if (board[0][i] == 'O') queue.add(Pair(0, i))
            if (board[rows-1][i] == 'O') queue.add(Pair(rows-1, i))
        }
        print(queue.size)
        while (queue.isNotEmpty()) {
            val (r, c) = queue.removeFirst()
            board[r][c] = 'T'
            for ((rr, rc) in directions) {
                val newRow = rr + r
                val newCol = rc + c
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) continue
                if (board[newRow][newCol] != 'O') continue
                queue.add(Pair(newRow, newCol))
            }
        }
        for (i in 0..rows-1) {
            for (j in 0..cols-1) {
                if (board[i][j] == 'T') board[i][j] = 'O'
                else if (board[i][j] == 'O') board[i][j] = 'X'
            }
        }
    }
}
