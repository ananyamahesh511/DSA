class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int cnt = 0;
        Map<Integer, Integer> prefix_cnt = new HashMap<>();

        prefix_cnt.put(0,1);

        for(int i=0; i<n; i++){
            sum += nums[i];

            if(prefix_cnt.containsKey(sum - k)){
                cnt+= prefix_cnt.get(sum-k);
            }

            prefix_cnt.put(sum, prefix_cnt.getOrDefault(sum, 0) + 1);
        }

        return cnt;
    }
}