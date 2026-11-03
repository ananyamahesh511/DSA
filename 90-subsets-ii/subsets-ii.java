class Solution {
    void util(int[] nums, int idx, List<Integer> ls, List<List<Integer>> res){
        res.add(new ArrayList<>(ls));
        for(int i=idx; i<nums.length; i++){
            if(i != idx && nums[i] == nums[i-1]) continue;

            ls.add(nums[i]);
            util(nums, i+1, ls, res);
            ls.remove(ls.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> ls = new ArrayList<>();

        util(nums, 0, ls, res);

        return res;
    }
}