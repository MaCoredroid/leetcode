class Solution {
    public int minSteps(int n) {
        int[][] dp=new int[n+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,n);
        }
        dp[1][0]=0;
        for(int i=1;i<=n;i++){
            int temp=dp[i][0];
            for(int j=0;j<=i;j++){
                temp=Math.min(temp,dp[i][j]);
            }
            dp[i][i]=Math.min(dp[i][i],temp+1);
            for(int j=0;j<=i;j++){
                if(i+j<=n){
                    dp[i+j][j]=Math.min(dp[i+j][j],dp[i][j]+1);
                }
            }
        }
        int ans=n;
        for(int j=0;j<=n;j++){
            ans=Math.min(ans,dp[n][j]);
        }
        return ans;
    }
}