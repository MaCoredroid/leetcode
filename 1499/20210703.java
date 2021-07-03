class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->(o2[1]-o2[0]-(o1[1]-o1[0])));
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<points.length;i++){
            while(!pq.isEmpty()&&pq.peek()[0]<points[i][0]-k){
                pq.poll();
            }
            if(!pq.isEmpty()){
                ans=Math.max(ans,points[i][0]+points[i][1]+pq.peek()[1]-pq.peek()[0]);
            }
            pq.offer(points[i]);
        }
        return ans;
    }
}