class Solution {
    int[][] directions = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}}; 
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return;
        if (grid[r][c] == '0') return;

        grid[r][c] = '0';
        for (int[] d: directions) dfs(grid, r + d[0], c + d[1]);
    }
}
