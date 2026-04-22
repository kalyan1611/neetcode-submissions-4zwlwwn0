class Solution {

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(board, word, visited, rows, cols, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, boolean[][] visited, int rows, int cols, int row, int col, int index) {
        
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row == rows || col < 0 || col == cols) {
            return false;
        }
        if (visited[row][col] == true || word.charAt(index) != board[row][col]) {
            return false;
        }

        visited[row][col] = true;

        if (dfs(board, word, visited, rows, cols, row + 1, col, index + 1)
            || dfs(board, word, visited, rows, cols, row - 1, col, index + 1)
            || dfs(board, word, visited, rows, cols, row, col + 1, index + 1)
            || dfs(board, word, visited, rows, cols, row, col - 1, index + 1)) {
            return true;
        }

        visited[row][col] = false;

        return false;
    }
}
