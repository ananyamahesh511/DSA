class Solution {
    void util(int[] nums, List<List<Integer>> res, List<Integer> ds, int idx){
        res.add(new ArrayList<>(ds));

        for(int i=idx; i<nums.length; i++){
            if(i != idx && nums[i] == nums[i-1]){
                continue;
            }

            ds.add(nums[i]);
            util(nums, res, ds, i+1);
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        
        util(nums, res, ds, 0);

        return res;
    }
}