class Solution {
    class Pair{
        int year;
        int pop;

        public Pair(int year, int pop){
            this.year = year;
            this.pop = pop;
        }
    }

    public int maximumPopulation(int[][] logs) {
        List<Pair> ls = new ArrayList<>();

        for(int i = 0; i< logs.length; i++){
            int birth = logs[i][0];
            ls.add(new Pair(birth, 1));

            int death = logs[i][1];
            ls.add(new Pair(death, -1));
        }

        Collections.sort(ls, (a, b) -> a.year == b.year ? a.pop - b.pop : a.year - b.year);

        int curpop = 0;
        int maxpop = 0;
        int yr = 0;

        for(int i = 0; i<ls.size(); i++){
            Pair p = ls.get(i);
            curpop += p.pop;
            if(curpop > maxpop){
                maxpop = Math.max(maxpop, curpop);
                yr = p.year;
            }
        }

        return yr;
    }
}