class Solution {
    public int[][] merge(int[][] intervals) {
        Stack<int[]> st = new Stack<>();
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));
        st.push(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            int[] arr = intervals[i];
            int[] temp = st.peek();

            if(arr[0] <= temp[1]){
                st.pop();
                st.push(new int[]{Math.min(arr[0], temp[0]), Math.max(arr[1], temp[1])});
            }else{
                st.push(arr);
            }
        }

        int[][] res = new int[st.size()][2];

        for(int i = res.length-1; i >= 0; i--){
            res[i] = st.pop();
        }

        return res;
    }
}