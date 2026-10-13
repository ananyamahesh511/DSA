class MyCalendarTwo {
    class Calendar{
        int st;
        int et;

        public Calendar(int st, int et){
            this.st = st;
            this.et = et;
        }
    }

    Map<Integer, Integer> map = new TreeMap<>();

    public MyCalendarTwo() {
        
    }
    
    public boolean book(int startTime, int endTime) {
        Calendar cal = new Calendar(startTime, endTime);
        map.put(startTime, map.getOrDefault(startTime, 0)+1);
        map.put(endTime, map.getOrDefault(endTime, 0)-1);

        int runningSum = 0;

        for(int k : map.keySet()){
            runningSum += map.get(k);
            if(runningSum > 2){
                map.put(startTime, map.getOrDefault(startTime, 0)-1);
                map.put(endTime, map.getOrDefault(endTime, 0)+1);

                return false;
            }
        }

        return true;

    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */