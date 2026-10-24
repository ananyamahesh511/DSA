class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int n = nums.length;

        int ps = 0;

        for(int i=0; i<n; i++){
            ps += nums[i];

            int rem = ps % k;

            if(map.containsKey(rem)){
                if(i - map.get(rem) >= 2) return true;
            }else{
                map.put(rem, i);
            }
        }

        return false;
    }
}