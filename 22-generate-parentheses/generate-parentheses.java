class Solution {
    void util(int n, List<String> res, StringBuilder str, int ocnt, int ccnt){
        if(str.length() == 2*n){
            res.add(new String(str.toString()));
            return;
        }

        if(ocnt < n){
            str.append('(');
            util(n, res, str, ocnt+1, ccnt);
            str.deleteCharAt(str.length() - 1);
        }

        if(ocnt > ccnt){
            str.append(')');
            util(n, res, str, ocnt, ccnt + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        util(n, res, new StringBuilder(), 0, 0);

        return res;
    }
}