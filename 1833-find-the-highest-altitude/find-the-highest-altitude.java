class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] alt = new int[n+1];
        alt[0] = 0;
        int res = 0;

        for(int i=1; i<alt.length; i++){
            alt[i] = alt[i-1] + gain[i-1];
            res = Math.max(res, alt[i]);
        }

        return res;
    }
}