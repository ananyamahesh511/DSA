class Solution {
    public int longestValidParentheses(String s) {
        int close = 0;
        int open = 0;
        int result = 0;

        //L -> R
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') open++;
            else close++;

            if(close > open){
                open = 0;
                close = 0;
            }

            if(open == close){
                result = Math.max(result, open+close);
            }
        }

        open = 0;
        close = 0;
        //R->L
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == '(') open++;
            else close++;

            if(open > close){
                open = 0;
                close = 0;
            }

            if(open == close){
                result = Math.max(result, open+close);
            }
        }

        return result;
    }
}