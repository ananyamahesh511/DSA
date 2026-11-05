class Solution {
    boolean isSafe(char[][] board, int r, int c, int n){
        //vertical - up
        for(int row = r-1; row>= 0; row--){
            if(board[row][c] == 'Q'){
                return false;
            }
        }

        //diagonal left up
        for(int row = r-1, col = c-1; row >= 0 && col >=0; row--, col--){
            if(board[row][col] == 'Q'){
                return false;
            }
        }

        //diagonal right up
        for(int row = r-1, col = c+1; row >= 0 && col < n; row--, col++){
            if(board[row][col] == 'Q'){
                return false;
            }
        }

        return true;
    }

    void util(char[][] board, int n, List<List<String>>res, int row){
        if(row == n){
            List<String> ls = new ArrayList<>();
            for(int r = 0; r < n; r++){
                ls.add(new String(board[r]));
            }
            res.add(ls);
            return;
        }

        for(int col = 0; col < n; col++){
            if(isSafe(board, row, col, n)){
                board[row][col] = 'Q';
                
                util(board, n, res, row+1);

                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        List<List<String>> res = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }

        util(board, n, res, 0);

        return res;
    }
}