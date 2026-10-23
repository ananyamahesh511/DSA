class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        int sum = 0;
        int i = 0;

        for(int j=0; j<n; j++){
            sum += nums[j];

            while(sum >= target){
                res = Math.min(res, j-i+1);

                //shrink
                sum -= nums[i];
                i++;
            }
        }

        if(res == Integer.MAX_VALUE) return 0;
        return res;
    }
}