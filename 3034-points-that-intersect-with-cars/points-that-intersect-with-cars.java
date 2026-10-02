class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] sweep = new int[101];
        Arrays.fill(sweep, 0);
        int sum = 0;

        for(int i = 0; i < nums.size(); i++){
            for(int j = nums.get(i).get(0); j <= nums.get(i).get(1); j++){
                sweep[j] = 1;
            }
        }

        for(int i = 0; i < sweep.length; i++){
            sum += sweep[i];
        }

        return sum;
    }
}