class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int len:sticks){
            pq.offer(len);
        }
        int ans=0;
        while(pq.size()>1){
            int small1=pq.poll();
            int small2=pq.poll();
            ans+=small1+small2;
            pq.offer(small1+small2);
        }
        return ans;
    }
}