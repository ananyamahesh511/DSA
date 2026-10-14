class Solution {
    int cnt = 0;

    void util(int idx, int sum, int t, int[] nums){
        //base cases
        if(idx == nums.length && sum == t){
            cnt++;
            return;
        }

        if(idx == nums.length) return;

        //pick (+)
        util(idx+1, sum+nums[idx], t, nums);

        //pick (-)
        util(idx+1, sum-nums[idx], t, nums);
    }

    public int findTargetSumWays(int[] nums, int target) {
        util(0, 0, target, nums);

        return cnt;
    }
}