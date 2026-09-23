class Solution {
    void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    void util(int[] nums, List<List<Integer>> res, int idx){
        //Base case
        if(idx == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                temp.add(nums[i]);
            }
            res.add(temp);
            return;
        }

        for(int i = idx; i < nums.length; i++){
            //swap
            swap(i, idx, nums);

            //recursive call
            util(nums, res, idx+1);

            //undoing the swap
           swap(i, idx, nums);
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        util(nums, res, 0);

        return res;
    }
}