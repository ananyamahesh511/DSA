class Solution {
    void util(int[] arr, int t, List<List<Integer>> ans, List<Integer> ls, int idx){
        if(idx == arr.length && t == 0){
            ans.add(new ArrayList<>(ls));
            return;
        }

        if(idx == arr.length || t < 0){
            return;
        }

        //pick
        ls.add(arr[idx]);
        util(arr, t-arr[idx], ans, ls, idx);
        ls.remove(ls.size() - 1);

        //not-pick
        util(arr, t, ans, ls, idx+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();

        util(candidates, target, ans, ls, 0);

        return ans;
    }
}