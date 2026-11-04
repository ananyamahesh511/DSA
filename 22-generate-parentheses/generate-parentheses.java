class Solution {
    void util(int n, List<String> res, int ocnt, int ccnt, StringBuilder str){
        if(str.length() == 2*n){
            String s = str.toString();
            res.add(s);
        }

        if(ocnt < n){
            str.append('(');
            util(n, res, ocnt+1, ccnt, str);
            str.deleteCharAt(str.length() - 1);
        }

        if(ocnt > ccnt){
            str.append(')');
            util(n, res, ocnt, ccnt+1, str);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        int ocnt = 0;
        int ccnt = 0;

        util(n, res, ocnt, ccnt, str);

        return res;
    }
}