public class _2sudoku {
    public static void main(String[] args) {
        char board[][] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        helper(board, 0, 0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static boolean helper(char board[][], int row, int col) {

        if (row == board.length) {
            return true;
        }

        int nrow = 0, ncol = 0;
        if (col != board.length - 1) {
            ncol = col + 1;
            nrow = row;
        } else {
            ncol = 0;
            nrow = row + 1;
        }

        if (board[row][col] != '.') {
            if (helper(board, nrow, ncol))
                return true;
        } else {
            for (int i = 1; i <= 9; i++) {
                if (isSafe(board, row, col, i)) {
                    board[row][col] = (char) (i + '0');
                    if (helper(board, nrow, ncol))
                        return true;
                    else
                        board[row][col] = '.';
                }
            }
        }
        return false;

    }

    public static boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == (char) (n + '0'))
                return false;
            if (board[i][col] == (char) (n + '0'))
                return false;
        }

        int c = (col / 3) * 3;
        int r = (row / 3) * 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == (char) (n + '0'))
                    return false;
            }
        }
        return true;

    }

}
