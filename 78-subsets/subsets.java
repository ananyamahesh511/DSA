class Solution {
    Set<List<Integer>> set = new HashSet<>();

    void util(int idx, int[] nums, List<Integer> temp){
        if(idx == nums.length){
            set.add(new ArrayList<>(temp));
            return;
        }

        //pick
        temp.add(nums[idx]);
        util(idx+1, nums, temp);
        temp.remove(temp.size() - 1);

        //not pick
        util(idx+1, nums, temp);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();

        util(0, nums, new ArrayList<>());

        for(List<Integer> p : set){
            ls.add(p);
        }

        return ls;
    }
}