class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n-1;
        int maxHt = 0;

        while(l < r){
            int ht = Math.min(height[l], height[r]) * (r-l);
            maxHt = Math.max(maxHt, ht);

            if(height[l] <= height[r]){
                l++;
            }else{
                r--;
            }

        }

        return maxHt;
    }
}