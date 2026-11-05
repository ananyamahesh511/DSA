class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        map.put(0, 1);

        int ps = 0;

        for(int i=0; i<nums.length; i++){
            ps += nums[i];

            int rem = ps - k;

            if(map.containsKey(rem)){
                cnt += map.get(rem);
            }

            map.put(ps, map.getOrDefault(ps, 0) + 1);
        }

        return cnt;
    }
}