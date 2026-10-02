class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m - 1;
        int idx2 = m + n - 1;
        int idx3 = n - 1;

        while(idx3 >= 0 && idx1 >= 0){
            if(nums2[idx3] >= nums1[idx1]){
                nums1[idx2--] = nums2[idx3--];
            }else{
                nums1[idx2--] = nums1[idx1--];
            }
        }

        while(idx3 >= 0){
            nums1[idx2--] = nums2[idx3--];
        }
    }
}