//Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

//The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] used = new boolean[9];
        for(int i = 0; i < 9; i++){
            fillFalse(used);
            for(int j = 0; j < 9; j++){
                if(!check(board[i][j], used)) return false;
            }
            fillFalse(used);
            for(int j = 0; j < 9; j++){
                if(!check(board[j][i], used)) return false;
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                fillFalse(used);
                for(int r = i*3; r < i*3+3; r++){
                    for(int c = j*3; c < j*3+3; c++){
                        if(!check(board[r][c], used)) return false;
                    }
                }
            }
        }
        return true;
    }
    private void fillFalse(boolean[] used){
        for(int i = 0; i < used.length; i++){
            used[i] = false;
        }
    }
    private boolean check(char ch, boolean[] used){
        if(ch == '.') return true;
        if(used[ch - '1']) return false;
        used[ch - '1'] = true;
        return true;
    }
}