class Solution {
    public int maxSubArray(int[] nums) {
        int cur_sum = 0;
        int best = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            cur_sum = Math.max(cur_sum + nums[i], nums[i]);
            best = Math.max(cur_sum, best);
        }

        return best;
    }
}