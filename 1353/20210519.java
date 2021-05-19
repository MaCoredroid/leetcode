class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>(){
            public int compare(int[] event1,int[] event2){
                return event1[0]-event2[0];
            }
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int day=0,id=0,res=0;
        while(id<events.length||!pq.isEmpty()){
            if(pq.isEmpty()){
                pq.add(events[id][1]);
                day=events[id++][0];
            }
            while(id<events.length&&events[id][0]<=day){
                pq.add(events[id++][1]);
            }
            if(pq.peek()>=day){
                day++;
                res++;
            }
            pq.poll();
        }
        return res;
    }
}