class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val queueP = ArrayDeque<Pair<Int,Int>>()
        val queueA = ArrayDeque<Pair<Int,Int>>()
        val result = mutableSetOf<List<Int>>()
        val directions = listOf(Pair(0,1), Pair(0,-1), Pair(1,0), Pair(-1,0))
        val visited = mutableSetOf<Pair<Int,Int>>()
        val rows = heights.size
        val cols = heights[0].size
        for(i in 0..rows-1) {
            queueP.add(Pair(i,0))
            queueA.add(Pair(i,cols-1))
        }
        for(i in 0..cols-1) {
            queueP.add(Pair(0, i))
            queueA.add(Pair(rows-1, i))
        }
        val pointReachedAtP = mutableListOf<Pair<Int,Int>>()
        while (queueP.isNotEmpty()) {
            val pointReached= queueP.removeFirst()
            pointReachedAtP.add(pointReached)
            visited.add(pointReached)
            val (currRow, currCol) = pointReached
            for((r, c) in directions) {
                val newRow = currRow+r
                val newCol = currCol+c
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) continue
                val pointsPair = Pair(newRow, newCol)
                if (visited.contains(pointsPair) || heights[newRow][newCol] < heights[currRow][currCol]) continue

                queueP.add(pointsPair)
            }
        }
        val pointReachedAtA = mutableSetOf<Pair<Int,Int>>()
        visited.clear()
        while (queueA.isNotEmpty()) {
            val pointReached= queueA.removeFirst()
            pointReachedAtA.add(pointReached)
            visited.add(pointReached)
            
            val (currRow, currCol) = pointReached
            for ((r, c) in directions) {
                val newRow = currRow+r
                val newCol = currCol+c

                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) continue
                val pointsPair = Pair(newRow, newCol)
                if (visited.contains(pointsPair) || heights[newRow][newCol] < heights[currRow][currCol]) continue
                queueA.add(pointsPair)
            }
        }

        return pointReachedAtA.intersect(pointReachedAtP).toList().map {listOf(it.first, it.second)}
    }
}
