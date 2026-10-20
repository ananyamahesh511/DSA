class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = Character.toLowerCase(s.charAt(i));
            if(Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }
        }

        String str = sb.toString();

        int n = str.length();
        int l = 0;
        int r = n-1;

        char[] arr = str.toCharArray();

        while(l <= r){
            if(arr[l] != arr[r]){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}