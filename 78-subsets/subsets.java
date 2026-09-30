class Solution {
    void util(int[] nums, int idx, Set<List<Integer>> set, List<Integer> temp){
        if(idx == nums.length){
            set.add(new ArrayList<>(temp));
            return;
        }

        //picked
        temp.add(nums[idx]);
        util(nums, idx+1, set, temp);
        temp.remove(temp.size() - 1);
        //not picked
        util(nums, idx+1, set, temp);
    }
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> temp = new ArrayList<>();

        util(nums, 0, set, temp);

        return new ArrayList<>(set);
    }
}