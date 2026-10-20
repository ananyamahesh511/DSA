class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        int l=0;
        int r=n-1;

        for(int i=n-1; i>=0; i--){
            if(Math.abs(nums[l]) >= Math.abs(nums[r])){
                arr[i] = nums[l] * nums[l];
                l++;
            }else{
                arr[i] = nums[r] * nums[r];
                r--;
            }
        }

        return arr;
    }
}