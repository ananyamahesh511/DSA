class Solution {
    public int minChanges(String s) {
        int res = 0;

        int n = s.length();

        for(int i=0; i<n; i+=2){
            int z = 0;
            int o = 0;

            if(Integer.parseInt(s.charAt(i)+"") == 1) o++;
            else z++;

            if(Integer.parseInt(s.charAt(i+1)+"") == 1) o++;
            else z++;

            if(z != 0 && o != 0){
                res += Math.min(z, o);
            }
        }

        return res;
    }
}