class Solution {
    int util(int[] nums, int low, int high, int t){
        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] == t){
                return mid;
            }else if(nums[mid] > t){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int pivot = -1;
        int n = nums.length;

        for(int i=0; i<n-1; i++){
            if(nums[i] > nums[i+1]){
                pivot = i;
            }
        }

        if(pivot == -1){
            return util(nums, 0, n-1, target);
        }

        else if(target >= nums[0] && target <= nums[pivot]){
            return util(nums, 0, pivot, target);
        }

        else{
            return util(nums, pivot+1, n-1, target);
        }
    }
}