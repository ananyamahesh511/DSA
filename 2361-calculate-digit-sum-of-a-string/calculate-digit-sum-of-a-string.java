class Solution {
    String util(String s, int k){
        if(s.length() <= k){
            return s;
        }

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i < s.length() ; i+=k){
            int grp_sum = 0;

            for (int j = i; j < Math.min(i + k, s.length()); j++) {
                grp_sum += s.charAt(j) - '0';
            }

            sb.append(grp_sum);
        }

        return util(sb.toString(), k);
    }
    public String digitSum(String s, int k) {

        return util(s, k);
    }
}