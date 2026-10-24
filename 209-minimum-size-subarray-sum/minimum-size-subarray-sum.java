class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 0;
        int sum = 0;

        int min_len = Integer.MAX_VALUE;

        for(int r=0; r<n; r++){
            sum += nums[r];

            while(sum >= target){
                min_len = Math.min(min_len, r-l+1);

                sum -= nums[l];
                l++;
            }
        }

        if(min_len == Integer.MAX_VALUE) return 0;
        
        return min_len;
    }
}