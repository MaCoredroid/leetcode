class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2)->(o2-o1));
        int ans=0;
        int tank=startFuel;
        int prev=0;
        for(int i=0;i<stations.length;i++){
            tank-=stations[i][0]-prev;
            while(!pq.isEmpty()&&tank<0){
                ans++;
                tank+=pq.poll();
            }
            if(tank<0){
                return -1;
            }
            pq.offer(stations[i][1]);
            prev=stations[i][0];
        }
        tank -= target - prev;
        while (!pq.isEmpty() && tank < 0) {
            tank += pq.poll();
            ans++;
        }
        if (tank < 0) return -1;
        return ans;
    }
}