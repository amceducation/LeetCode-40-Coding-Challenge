class Solution {
    int[] rows = new int[9];
    int[] cols = new int[9];
    int[] boxes = new int[9];
    char[][] board;
    boolean solved = false;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int d = board[r][c] - '1';
                    int bit = 1 << d;
                    rows[r] |= bit;
                    cols[c] |= bit;
                    boxes[(r / 3) * 3 + c / 3] |= bit;
                }
            }
        }
        backtrack(0);
    }

    private void backtrack(int pos) {
        if (pos == 81) {
            solved = true;
            return;
        }
        int r = pos / 9, c = pos % 9;
        if (board[r][c] != '.') {
            backtrack(pos + 1);
            return;
        }
        int box = (r / 3) * 3 + c / 3;
        int mask = ~(rows[r] | cols[c] | boxes[box]) & 0x1FF;

        while (mask != 0 && !solved) {
            int bit = mask & -mask; // lowest set bit
            int d = Integer.numberOfTrailingZeros(bit);
            board[r][c] = (char) ('1' + d);
            rows[r] |= bit;
            cols[c] |= bit;
            boxes[box] |= bit;

            backtrack(pos + 1);

            if (!solved) {
                board[r][c] = '.';
                rows[r] ^= bit;
                cols[c] ^= bit;
                boxes[box] ^= bit;
            }
            mask ^= bit;
        }
    }
}