class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int maxDepth = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(ch == '('){
                st.push(ch);
            }else if(ch == ')'){
                st.pop();
            }

            maxDepth = Math.max(maxDepth, st.size());
        }

        return maxDepth;
    }
}