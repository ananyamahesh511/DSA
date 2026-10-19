class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int r = 1;
        int w = 1;

        while(r < n){
            if(nums[r] == nums[r-1]) r++;
            else{
                nums[w] = nums[r];
                w++;
                r++;
            }
        }

        return w;
    }
}