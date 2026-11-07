class Solution {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int n = height.length;

        int l = 0;
        int r = n - 1;

        while(l < r){
            int area = Math.min(height[l], height[r]) * (r - l);
            maxArea = Math.max(area, maxArea);
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }

        return maxArea;
    }
}