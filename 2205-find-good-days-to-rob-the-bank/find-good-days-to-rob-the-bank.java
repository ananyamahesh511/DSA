class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> ls = new ArrayList<>();
        int n = security.length;

        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = 0;
        right[n-1] = 0;

        //left
        for(int i=1; i<n; i++){
            if(security[i-1] >= security[i]){
                left[i] = left[i-1]+1;
            }else{
                left[i] = 0;
            }
        }

        //right
        for(int i=n-2; i>=0; i--){
            if(security[i] <= security[i+1]){
                right[i] = right[i+1] + 1; 
            }else{
                right[i] = 0;
            }
        }

        for(int i=0; i<n; i++){
            if(left[i] >= time && right[i] >= time){
                ls.add(i);
            }
        }

        return ls;
    }
}