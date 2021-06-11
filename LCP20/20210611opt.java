class Solution {
    final int MOD = (int)1e9 + 7;
    public int busRapidTransit(int target, int inc, int dec, int[] jump, int[] cost) {
        int n=jump.length;
        PriorityQueue<long[]> pq=new PriorityQueue<long[]>((o1,o2)->(int)((o1[0]-o2[0])%MOD));
        pq.offer(new long[]{0,target});
        HashSet<Long> visit = new HashSet<>();
        long res = (long)target * inc;
        while(!pq.isEmpty()){
            long[] temp=pq.poll();
            if(visit.contains(temp[1])){
                continue;
            }
            visit.add(temp[1]);
            res=Math.min(res,temp[0]+(long)temp[1]*inc);
            if(temp[1]==1){
                break;
            }
            pq.offer(new long[]{temp[0]+(long)(temp[1]-1)*inc,1});
            for(int i=0;i<n;i++){
                long reminder=temp[1]%jump[i];
                long prev=temp[1]/jump[i];
                if(reminder==0){
                    pq.offer(new long[]{temp[0]+cost[i],prev});
                }else{
                    pq.offer(new long[]{temp[0]+cost[i]+reminder*inc,prev});
                    pq.offer(new long[]{temp[0]+cost[i]+(jump[i]-reminder)*dec,prev+1});
                }
            }
        }
        return (int)(res%MOD);
    }
}