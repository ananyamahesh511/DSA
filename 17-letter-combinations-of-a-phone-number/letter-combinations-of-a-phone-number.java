class Solution {
    void util(String digits, List<String> res, int idx, StringBuilder s, Map<Character, String> map){
        if(idx == digits.length()){
            res.add(new String(s.toString()));
            return;
        }

        String str = map.get(digits.charAt(idx));

        for(int i=0; i<str.length(); i++){
            s.append(str.charAt(i));
            util(digits, res, idx+1, s, map);
            s.deleteCharAt(s.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();

        util(digits, res, 0, new StringBuilder(), map);

        return res;
    }
}