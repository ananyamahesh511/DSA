class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int curBest = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            sum = Math.max(sum+nums[i], nums[i]);
            curBest = Math.max(curBest, sum);
        }

        return curBest;
    }
}