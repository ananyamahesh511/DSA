class Solution {
    void util(int[] nums, boolean[] vis, List<List<Integer>> res, List<Integer>ls, int n){
        if(ls.size() == n){
            res.add(new ArrayList<>(ls));
            return;
        }
        
        for(int i=0; i<n; i++){
            if(vis[i] != true){
                //recurse
                ls.add(nums[i]);
                vis[i] = true;

                //call
                util(nums, vis, res, ls, n);

                //backtrack
                ls.remove(ls.size() - 1);
                vis[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        boolean[] vis = new boolean[n];

        util(nums, vis, res, ls, n);

        return res;
    }
}