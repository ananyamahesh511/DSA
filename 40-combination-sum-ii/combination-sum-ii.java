class Solution {
    void util(List<Integer> ls, int t, int idx, List<List<Integer>> res, int[] arr){
        if(t == 0){
            res.add(new ArrayList<Integer>(ls));
            return;
        }

        for(int i = idx; i < arr.length; i++){
            if(i > idx && arr[i] == arr[i-1]){
                continue;
            }

            if(arr[i] > t){
                break;
            }

            ls.add(arr[i]);

            util(ls, t-arr[i], i+1, res, arr);

            ls.remove(ls.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();

        int n = candidates.length;
        List<Integer> ls = new ArrayList<>();

        util(ls, target, 0, res, candidates);

        return res;
    }
}