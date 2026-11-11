class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int cursum = 0;
        int maxLen = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                cursum += -1;
            }else{
                cursum += 1;
            }

            if(map.containsKey(cursum)){
                maxLen = Math.max(maxLen, i-map.get(cursum));
            }

            else map.put(cursum, i);
        }

        return maxLen;
    }
}