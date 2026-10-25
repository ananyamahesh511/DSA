class Solution {
    public int pivotIndex(int[] nums) {
        int piv_idx = Integer.MAX_VALUE;
        int n = nums.length;
        int[] arr = new int[n];
        int left = 0;
        int right = 0;

        for(int i=0; i<n; i++){
            arr[i] = left;
            left += nums[i];
        }

        for(int i=n-1; i>=0; i--){
            if(right == arr[i]){
                piv_idx = Math.min(piv_idx, i);
            }
            right += nums[i];
        }

        if(piv_idx == Integer.MAX_VALUE) return -1;

        return piv_idx;
    }
}