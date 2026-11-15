class Solution {
    boolean util(Map<Character, Integer>maps, Map<Character, Integer>mapt){
        for(char key : mapt.keySet()){
            if(!(maps.containsKey(key))){
                return false;
            }
            if(maps.get(key) < mapt.get(key)){
                return false;
            }
        }

        return true;
    }

    public String minWindow(String s, String t) {
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        Map<Character, Integer> maps = new HashMap<>();
        Map<Character, Integer> mapt = new HashMap<>();

        for(char ch : t.toCharArray()){
            mapt.put(ch, mapt.getOrDefault(ch, 0)+1);
        }

        int n = s.length();
        int l = 0;
        int r = 0;

        while(r < n){
            char ch = s.charAt(r);
            maps.put(ch, maps.getOrDefault(ch, 0)+1);

            while(util(maps, mapt)){
                if(r-l+1 < ans){
                    ans = r-l+1;
                    start = l;
                    end = r;
                }

                maps.put(s.charAt(l), maps.get(s.charAt(l)) - 1);

                if(maps.get(s.charAt(l)) == 0){
                    maps.remove(s.charAt(l));
                }

                l++;
            }

            r++;
        }
        if(ans == Integer.MAX_VALUE) return new String();

        return s.substring(start, end+1);
    }
}