class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;
            
            int val = nums[i];
            int rem = 0 - val;

            int j = i+1;
            int k = n-1;

            while(j < k){
                int sum = nums[j] + nums[k];

                if(sum < rem){
                    j++;
                }else if(sum > rem){
                    k--;
                }else{
                    res.add(Arrays.asList(val, nums[j], nums[k]));
                    j++;
                    k--;

                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }

        return res;
    }
}