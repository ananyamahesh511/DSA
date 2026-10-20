class Solution {
    public int[] sortedSquares(int[] nums) {
      for(int i=0; i<nums.length; i++){
        int n = nums[i];
        nums[i] = (int) Math.abs(n);
      }  

      Arrays.sort(nums);

      int[] res = new int[nums.length];
      for(int i=0; i<nums.length; i++){
        res[i] = nums[i] * nums[i];
      }

      return res;
    }
}