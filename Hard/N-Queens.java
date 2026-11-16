class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(0, n, board, ans);
        return ans;
    }

    private void backtrack(int row, int n, char[][] board, List<List<String>> ans) {
        if (row == n) {
            List<String> sol = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sol.add(new String(board[i]));
            }
            ans.add(sol);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                backtrack(row + 1, n, board, ans);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board, int n) {
        // same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        // right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}