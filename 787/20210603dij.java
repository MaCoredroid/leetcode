class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] graph=new int[n][n];
        for(int[] flight:flights){
            graph[flight[0]][flight[1]]=flight[2];
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a1,a2)->(a1[1]-a2[1]));
        pq.offer(new int[]{src,0,k+1});
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            int source=temp[0];
            if(source==dst){
                return temp[1];
            }
            if(temp[2]==0){
                continue;
            }
            for(int j=0;j<graph[0].length;j++){
                if(graph[source][j]>0){
                    pq.offer(new int[]{j,temp[1]+graph[source][j],temp[2]-1});
                }
            }
        }
        return -1;
    }
}