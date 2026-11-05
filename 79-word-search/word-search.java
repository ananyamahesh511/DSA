class Solution {
    boolean util(char[][] board, String word, int r, int c, int idx){
        if(idx == word.length()){
            return true;
        }

        if(!(r>=0 && r<board.length && c>=0 && c<board[0].length)) return false;

        if(board[r][c] == '#' || board[r][c] != word.charAt(idx)) return false;

        char ch = board[r][c];

        board[r][c] = '#'; //mark as visited

        //search left
        boolean ans1 = util(board, word, r, c-1, idx+1);
        //search right
        boolean ans2 = util(board, word, r, c+1, idx+1);
        //search up
        boolean ans3 = util(board, word, r-1, c, idx+1);
        //search down
        boolean ans4 = util(board, word, r+1, c, idx+1);

        //backtrack
        board[r][c] = ch;

        return ans1 || ans2 || ans3 || ans4;
    }

    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(util(board, word, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }
}