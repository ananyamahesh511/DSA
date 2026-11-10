class Solution {
    boolean util(int[] nums, int low, int high, int t){
        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] == t){
                return true;
            }else if(nums[mid] > t){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return false;
    }

    public boolean search(int[] nums, int target) {
        int pivot = -1;
        int n = nums.length;

        for(int i=0; i<n-1; i++){
            if(nums[i] > nums[i+1]){
                pivot = i;
                break;
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