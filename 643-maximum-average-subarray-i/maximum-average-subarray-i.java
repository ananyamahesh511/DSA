class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double maxAvg = Integer.MIN_VALUE;
        double sum = 0;

        for(int i=0; i<n; i++){
            sum += nums[i];

            if(i >=k){
                sum -= nums[i-k];
            }

            if(i >= k-1){
                maxAvg = Math.max(maxAvg, sum/k);
            }
        }

        return maxAvg;
    }
}