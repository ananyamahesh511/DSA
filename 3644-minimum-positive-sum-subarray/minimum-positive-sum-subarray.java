class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int res = Integer.MAX_VALUE;
        int[] prefix = new int[n];
        prefix[0] = nums.get(0);
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + nums.get(i);
        }

        for(int i=0; i<n; i++){
           for(int len = l; len <= r && i+len-1 < n; len++){
            int j = i + len - 1;

            int sum = (i == 0) ? prefix[j] : prefix[j] - prefix[i-1];

            if(sum > 0 ){
                res = Math.min(res, sum);
            }
           }
        }

        if(res == Integer.MAX_VALUE) return -1;
        return res;
    }
}