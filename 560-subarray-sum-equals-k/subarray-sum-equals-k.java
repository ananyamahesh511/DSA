class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefix_cnt = new HashMap<>();
        prefix_cnt.put(0, 1);

        int ps = 0;
        int n = nums.length;
        int cnt = 0;

        for(int i=0; i<n; i++){
            ps += nums[i];

            int req = ps - k;
            

            if(prefix_cnt.containsKey(req)){
                cnt += prefix_cnt.get(req);
            }

            prefix_cnt.put(ps, prefix_cnt.getOrDefault(ps, 0) + 1);
        }

        return cnt;
    }
}