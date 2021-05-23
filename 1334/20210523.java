class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dp=new int[n][n];
        for(int[] res:dp){
            Arrays.fill(res,10001);
        }
        for(int[] edge:edges){
            dp[edge[0]][edge[1]]=edge[2];
            dp[edge[1]][edge[0]]=edge[2];
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                if(i==k||dp[i][k]==10001){
                    continue;
                }
                for(int j=i+1;j<n;j++){
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                    dp[j][i]=dp[i][j];
                }
            }
        }
        int res=n;
        int ret=-1;
        for(int i=0;i<n;i++){
            int curr=0;
            for(int j=0;j<n;j++){
                if(dp[i][j]<=distanceThreshold){
                    curr++;
                }
            }
            if(curr<=res){
                ret=i;
                res=curr;
            }
        }
        return ret;
    }
}