class Solution {
    boolean isPal(String str){
        int n = str.length();
        for(int i=0; i<n/2; i++){
            if(str.charAt(i) != str.charAt(n-i-1)) return false;
        }

        return true;
    }

    void util(String s, int idx, List<String> path, List<List<String>> res){

        if(idx == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i= idx; i<s.length(); i++){
            String str = s.substring(idx, i+1);
            if(isPal(str)){
                path.add(str);
                util(s, i+1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        util(s, 0, path, res);

        return res;
    }
}