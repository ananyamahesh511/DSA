class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] res = new int[nums.length];

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 0;
        right[nums.length-1] = 0;

        for(int i=1; i <nums.length; i++){
            left[i] = left[i-1]+nums[i-1];
        }

        for(int i=nums.length-2; i>=0; i--){
            right[i] = right[i+1]+nums[i+1];
        }

        for(int i=0; i<nums.length; i++){
            int left_contr = (i * nums[i]) - left[i];
            int right_contr = right[i] - (nums.length - i -1) *nums[i];
            res[i] += left_contr + right_contr;
        }

        return res;
    }
}