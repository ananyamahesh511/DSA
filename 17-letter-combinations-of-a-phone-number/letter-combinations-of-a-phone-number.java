class Solution {
    void util(int i, String digits, StringBuilder temp, List<String> ans, Map<Character, String> map){

        if(i == digits.length()){
            ans.add(temp.toString());
            return;
        }

        String str = map.get(digits.charAt(i));
        for(int j=0; j<str.length(); j++){
            temp.append(str.charAt(j));
            util(i+1, digits, temp, ans, map);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('0', "");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder temp = new StringBuilder();
        List<String> ans = new ArrayList<>();

        util(0, digits, temp, ans, map);

        return ans;
    }
}