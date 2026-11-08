class Solution {
    boolean isPal(String str){
        int n = str.length();
        
        for(int i=0; i< n/2; i++){
            if(str.charAt(i) != str.charAt(n-i-1)) return false;
        }

        return true;
    }
    void util(String s, List<List<String>> res, List<String> ls, int idx){
        if(idx == s.length()){
            res.add(new ArrayList<>(ls));
            return;
        }

        for(int i = idx; i<s.length(); i++){
            String str = s.substring(idx, i+1);
            if(isPal(str)){
                ls.add(str);
                util(s, res, ls, i+1);
                ls.remove(ls.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ls = new ArrayList<>();

        util(s, res, ls, 0);

        return res;
    }
}