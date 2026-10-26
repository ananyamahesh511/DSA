class Solution {
    void util(int idx, int[] nums, List<Integer> temp, List<List<Integer>> ls){
        if(idx == nums.length){
            ls.add(new ArrayList<>(temp));
            return;
        }

        //pick
        temp.add(nums[idx]);
        util(idx+1, nums, temp, ls);
        temp.remove(temp.size() - 1);

        //not pick
        util(idx+1, nums, temp, ls);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();

        util(0, nums, new ArrayList<>(), ls);

        return ls;
    }
}