class Solution {
    boolean isSafe(int n, char[][] board, int row, int col){
        //up
        for(int r = row - 1; r>=0; r--){
            if(board[r][col] == 'Q') return false;
        }

        //diagonal left up
        for(int r=row-1, c = col-1; r>=0 && c>=0; r--, c--){
            if(board[r][c] == 'Q') return false;
        }

        //diagonal right up
        for(int r=row-1, c = col+1; r>=0 && c<n; r--, c++){
            if(board[r][c] == 'Q') return false;
        }

        return true;
    }
    void util(List<List<String>> res, char[][] board, int n, int row){
        if(row == n){
            List<String> ls = new ArrayList<>();
            for(int r=0; r<n; r++){
                ls.add(new String(board[r]));
            }

            res.add(ls);
        }

        for(int col = 0; col < n; col++){
            if(isSafe(n, board, row, col)){
                board[row][col] = 'Q';
                util(res, board, n, row+1);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }

        util(res, board, n, 0);

        return res;
    }
}