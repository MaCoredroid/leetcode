class Solution {
    private int MAX_VALUE = 99999999; 
    public int mergeStones(int[] stones, int k) {
        int n=stones.length;
        if ((n - 1) % (k - 1) != 0) return -1;
        int[][][] dp = new int[n][n][k + 1];
        int[] sum = new int[n + 1];
        for(int i=0;i<n;i++){
            sum[i+1]=sum[i]+stones[i];
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                for (int m = 2; m <= k; ++m) dp[i][j][m] = MAX_VALUE;
            }
            dp[i][i][1] = 0;
        }
        for(int len=2;len<=n;len++){
            for(int start=0;start+len-1<n;start++){
                int end=start+len-1;
                for(int m=2;m<=k;m++){
                    for(int p=start;p<end;p+=k-1){
                        dp[start][end][m]=Math.min(dp[start][end][m],dp[start][p][1]+dp[p+1][end][m-1]);
                    }
                }
                dp[start][end][1]=dp[start][end][k]+sum[end+1]-sum[start];
            }
        }
        return dp[0][n-1][1];

    }
}