class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int curBest = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            curSum = Math.max(curSum + nums[i], nums[i]);
            curBest = Math.max(curBest, curSum);
        }

        return curBest;
    }
}