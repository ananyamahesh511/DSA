class Solution {
    boolean isViolation(int[] freq, int x){
        for(int a=1; a <= 500; a++){
            if(freq[a] == 0) continue;

            //case1: a + b = x
            int b = x - a;

            if(b>=0 && b<= 500 && freq[b] > 0){
                if(a == b) {
                    if(freq[a] >= 2) return true;
                }else if(a != b){
                    return true;
                }
            }

            //case2: x + a = b
            b = x + a;

            if(b>=0 && b<=500 && freq[b] > 0){
                return true;
            }
        }

        return false;
    }
    public int maxSubarray(int[] nums) {
        int n = nums.length;
        int[] freq = new int[501];

        int l = 0;
        int maxLen = 0;

        for(int r = 0; r < n; r++){
            int x = nums[r];

            while(isViolation(freq, x)){
                //shrink
                freq[nums[l]]--;
                l++;
            }

            freq[x]++;

            maxLen = Math.max(maxLen, r-l+1);
        }

        return maxLen;
    }
}