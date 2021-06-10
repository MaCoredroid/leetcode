class Solution {
    public int shortestPathLength(int[][] graph) {
        int N=graph.length;
        Queue<int[]> queue=new LinkedList<>();
        int[][] dp=new int[1<<N][N];
        for(int[] row:dp){
            Arrays.fill(row,N*N);
        }
        for(int i=0;i<N;i++){
            queue.offer(new int[]{1<<i,i});
            dp[1<<i][i]=0;
        }
        while(!queue.isEmpty()){
            int[] temp=queue.poll();
            int dis=dp[temp[0]][temp[1]];
            if(temp[0]==(1<<N)-1){
                return dis;
            }
            for(int next: graph[temp[1]]){
                int cover=temp[0]|(1<<next);
                if(dp[cover][next]>dis+1){
                    dp[cover][next]=dis+1;
                    queue.offer(new int[]{cover,next});
                }
            }
        }
        return -1;
    }
}