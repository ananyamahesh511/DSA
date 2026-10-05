class Solution {
    public int countGoodSubstrings(String s) {
        int k = 0;
        int l = 0;
        int r = 0;

        Set<Character> set = new HashSet<>();

        while(r < s.length()){
            char ch = s.charAt(r);
            if(!set.contains(ch)){
                set.add(ch);
            }
            else{
                while(set.contains(ch)){
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(ch);
            }

            if(set.size() == 3){
                k++;
                set.remove(s.charAt(l));
                l++;
            }
            r++;
            
        }

        return k;
    }
}