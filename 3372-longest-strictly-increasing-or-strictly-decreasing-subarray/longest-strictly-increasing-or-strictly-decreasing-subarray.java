class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int minCnt = 1;
        int maxCnt = 1;
        int res = 1;

        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[i-1]){
                maxCnt++;
                res = Math.max(minCnt, Math.max(maxCnt, res));
                minCnt = 1;
            }else if(nums[i] < nums[i-1]){
                minCnt++;
                res = Math.max(minCnt, Math.max(maxCnt, res));
                maxCnt = 1;
            }else{
                minCnt = 1;
                maxCnt = 1;
            }
        }

        return res;
    }
}