class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int n = nums.length;

        int base = 0;
        Map<String, Integer> map = new HashMap<>();
        int maxGain = 0;

        for(int i = 0; i < n - 1; i++){
            int a = nums[i];
            int b = nums[i + 1];

            if(a == b){
                base++;
            }else{
                int min = Math.min(a, b);
                int max = Math.max(a, b);

                String str = min + "#" + max;
                int count = map.getOrDefault(str, 0) + 1;

                map.put(str, count);

                maxGain = Math.max(maxGain, count);
            }
        }

        return base + maxGain;
    }
}