class Solution {
    int[][] directions = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    int rl=0;
    int cl =0;
    public int numIslands(char[][] grid) {
        int count = 0;
        rl = grid.length;
        cl = grid[0].length;
        for (int i = 0; i<rl; i++) {
            for (int j = 0;j<cl;j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int r, int c) {
        for (int[] dir: directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr < 0 || nr >= rl || nc < 0 || nc >= cl) continue;
            if (grid[nr][nc] == '0') continue;
            grid[nr][nc] = '0';
            dfs(grid, nr, nc);
        }
    }
}
