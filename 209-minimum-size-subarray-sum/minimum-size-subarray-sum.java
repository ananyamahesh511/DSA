class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int l = 0;
        int r = 0;

        while(r < n){
            sum += nums[r];

            while(sum >= target){
                res = Math.min(res, r-l+1);

                sum -= nums[l];
                l++;
            }

            r++;
        }

        if(res == Integer.MAX_VALUE) return 0;
        return res;
    }
}