class Solution {
    boolean util(char[][] board, int row, int col, String word, int idx){
        if(idx == word.length()){
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        if(board[row][col] == '#' ||  board[row][col] != word.charAt(idx)) return false;

        //mark char as visited
        char ch = board[row][col];
        board[row][col] = '#';

        boolean ans1 = util(board, row-1, col, word, idx+1);
        boolean ans2 = util(board, row+1, col, word, idx+1);
        boolean ans3 = util(board, row, col-1, word, idx+1);
        boolean ans4 = util(board, row, col+1, word, idx+1);

        board[row][col] = ch;

        return ans1||ans2||ans3||ans4;
    }
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(util(board, i, j, word, 0)){
                    return true;
                }
            }
        }

        return false;
    }
}