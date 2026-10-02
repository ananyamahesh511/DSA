class Solution {
    class Pair{
        int index;
        int passengers;

        public Pair(int index, int passengers){
            this.index = index;
            this.passengers = passengers;
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        List<Pair> ls = new ArrayList<>();

        for(int i = 0; i < trips.length; i++){
            int numPass = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];

            ls.add(new Pair(from, numPass));
            ls.add(new Pair(to, -numPass));
        }

        ls.sort((a, b)->{
            if(a.index == b.index){
                return a.passengers - b.passengers;
            }

            return a.index - b.index;
        });

        int runningSum = 0;

        for(Pair p : ls){
            runningSum += p.passengers;
            if(runningSum > capacity){
                return false;
            }
        }

        return true;
    }
}