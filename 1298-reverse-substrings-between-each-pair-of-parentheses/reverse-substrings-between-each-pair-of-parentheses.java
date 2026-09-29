class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        String res="";

        for(char ch : s.toCharArray()){
            if(ch != ')'){
                st.push(ch);
            }else{
                StringBuilder sb = new StringBuilder();
                while(st.peek() != '('){
                    sb.append(st.pop());
                }
                st.pop();

                for(char c : sb.toString().toCharArray()){
                    st.push(c);
                }

                res = sb.toString();
            }
            
        }

        if(!st.isEmpty()){
            StringBuilder sb1 = new StringBuilder();
            while(!st.isEmpty()){
                sb1.append(st.pop());
            }

            return sb1.reverse().toString();
        }

        return res;
    }
}