class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int r = 0;
        int w = 0;

        while(r < n){
            if(nums[r] == 0){
                r++;
            }else{
                int temp = nums[w];
                nums[w] = nums[r];
                nums[r] = temp;

                r++;
                w++;
            }
        }
    }
}