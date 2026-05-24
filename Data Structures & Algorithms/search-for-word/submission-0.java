class Solution {
    int rl;
    int cl;
    int[][] directions = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        rl = board.length;
        cl = board[0].length;
        for (int i = 0; i<rl; i++) {
            for(int j = 0;j < cl; j++) {
                if (backtrack(board, word, 0,i, j)) return true;
            }
        }
        return false;
    }

    boolean backtrack(char[][] board, String word, int index, int r, int c) {
        if (index == word.length()) return true;
        if (r < 0 || r >= rl || c < 0 || c >= cl) return false;
        if (word.charAt(index) != board[r][c]) return false;
        char temp = board[r][c];
        board[r][c] = '#';
        for (int[] d: directions) {
            if (backtrack(board, word, index+1, r+d[0], c+d[1])) return true;
        }
        board[r][c] = temp;
        return false;
    }
}
