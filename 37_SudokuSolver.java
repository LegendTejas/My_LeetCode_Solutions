class Solution {
    public void solveSudoku(char[][] board){
        solveSudoku(board, 0, 0);
    }

    public boolean solveSudoku(char[][] board, int iStart, int jStart){
        for(int i = iStart ; i < 9; i++, jStart = 0) {
            for(int j = jStart; j < 9; j++) {
                if(board[i][j] == '.'){  // Found an empty cell to fill
                    for(char p = '1'; p <= '9'; p++) {
                        if(isValidSudoku(board, i, j, p)){  // Check if placing digit `p` is valid at (i, j)
                            board[i][j] = p;
                            if(solveSudoku(board, i, j+1))  return true;  // Recurse to solve next cells
                            else board[i][j] = '.';  // Backtrack if placing `p` doesn't lead to solution
                        }
                    }
                    return false;  // No valid digit could be placed, trigger backtracking
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board, int row, int column, char num) {
        for(int i = 0; i < 9; i++) {
            if(num == board[i][column]) return false;  // Conflict in column
            if(num == board[row][i]) return false;     // Conflict in row

            int tempRow = 3 * (row / 3) + i / 3;
            int tempCol = 3 * (column / 3) + i % 3;
            if(board[tempRow][tempCol] == num) return false;  // Conflict in 3x3 subgrid
        }
        return true;
    }
}
