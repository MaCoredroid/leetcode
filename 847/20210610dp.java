class Solution {
    public int shortestPathLength(int[][] graph) {
        int N=graph.length;
        int[][] dp=new int[1<<N][N];
        for(int[] row:dp){
            Arrays.fill(row,N*N);
        }
        for(int x=0;x<N;x++){
            dp[1<<x][x]=0;
        }
        for(int cover=0;cover<1<<N;cover++){
            boolean repeat=true;
            while(repeat){
                repeat=false;
                for(int head=0;head<N;head++){
                    int d=dp[cover][head];
                    for(int next:graph[head]){
                        int cover2=cover|(1<<next);
                        if(d+1<dp[cover2][next]){
                            dp[cover2][next]=d+1;
                            repeat=true;
                        }
                    }
                }
            }
        }
        int ans=N*N;
        for(int i=0;i<N;i++){
            ans=Math.min(dp[(1<<N)-1][i],ans);
        }
        return ans;
    }
}