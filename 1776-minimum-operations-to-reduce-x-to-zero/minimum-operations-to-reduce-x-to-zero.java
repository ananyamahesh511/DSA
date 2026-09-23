class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }

        int sum_to_find = sum - x;

        if(sum_to_find < 0) return -1;

        //find longest subarray with sum_to_find

        int l = 0;
        int r = 0;
        int s = 0;
        int maxLen = Integer.MIN_VALUE;

        while(r < nums.length){
            s += nums[r];

            while(s > sum_to_find){
                //shrink
                s -= nums[l];
                l++;
            }

            //record answer
            if(s == sum_to_find) maxLen = Math.max(maxLen, r - l + 1);

            r++;
        }

        //return minOperations as : nums.length - maxLen

        if(maxLen != Integer.MIN_VALUE) return nums.length - maxLen;

        return -1;


    }
}