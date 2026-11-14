class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int res = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                int size = j-i+1;
                sum += nums.get(j);

                if(size >= l && size <= r && sum > 0){
                    res = Math.min(res, sum);
                }
            }
        }

        if(res == Integer.MAX_VALUE) return -1;
        return res;
    }
}