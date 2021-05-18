class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int stone:stones){
            pq.offer(stone);
        }
        while(pq.size()>1){
            int p=pq.poll();
            int q=pq.poll();
            if(p!=q){
                pq.offer(p-q);
            }
        }
        return pq.isEmpty()?0:pq.poll();

    }
}