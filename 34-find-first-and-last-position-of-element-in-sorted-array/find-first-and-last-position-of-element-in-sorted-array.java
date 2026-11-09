class Solution {
    int LB(int[] nums, int n, int target){
        int ans = n;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] >= target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int start = LB(nums, n, target);

        if(start == n || nums[start] != target){
            return new int[]{-1, -1};
        }

        int end = LB(nums, n, target+1) - 1;

        return new int[]{start, end};
    }
}