class Solution {
    void util(String s, List<String> ans, StringBuilder str, int idx, int partition){

        if(partition == 4){
            if(idx == s.length()){
                ans.add(str.toString());
            }
            return;
        }

        for(int i=idx; i<s.length(); i++){
            String string = s.substring(idx, i+1);

            //leading 0 codition
            if(string.length() > 1 && string.startsWith("0")){
                break;
            } 

            int number = Integer.parseInt(string);

            if(number >= 0 && number <= 255){
                int len = str.length();

                if(partition > 0){
                    str.append(".");
                }

                str.append(number);

                util(s, ans, str, i+1, partition+1);

                //backtrack
                str.setLength(len);
            }else{
                break;
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();
        StringBuilder str = new StringBuilder();

        util(s, ans, str, 0, 0);

        return ans;
    }
}