class Solution {
    public int minAddToMakeValid(String s) {
        int cnt = 0;
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(ch);
            }else{
                if(st.isEmpty()){
                    cnt++;
                }
                else{
                    st.pop();
                }
                
            }
        }

        if(!st.isEmpty()) cnt += st.size();

        return cnt;
    }
}