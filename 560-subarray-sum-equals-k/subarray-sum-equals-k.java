class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCnt = new HashMap<>();
        int sum = 0;
        int cnt = 0;

        prefixCnt.put(0, 1);

        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(prefixCnt.containsKey(sum - k)){
                cnt += prefixCnt.get(sum - k);
            }
            prefixCnt.put(sum, prefixCnt.getOrDefault(sum, 0) +1);
        }

        return cnt;
    }
}