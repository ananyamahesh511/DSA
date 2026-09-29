class Solution {
    void util(int n, int ocnt, int ccnt, String str, List<String> res){
        //BASE CASE
        if(str.length() == 2*n){
            res.add(str);
            return;
        }

        //left part
        if(ocnt < n){
            util(n, ocnt+1, ccnt, str+'(', res);
        }

        if(ccnt < ocnt){
            util(n, ocnt, ccnt+1, str+')', res);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String str = "";

        util(n, 0, 0, str, res);

        return res;
    }
}