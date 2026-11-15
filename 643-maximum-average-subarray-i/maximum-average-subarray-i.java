class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        double maxSum = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            sum += nums[i];

            if(i >= k){
                sum -= nums[i-k];
            }

            if(i >= k-1){
                maxSum = Math.max(maxSum, sum);
            }
        }

        double res = maxSum / k;

        return res;
    }
}