class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1];
        for(int len=2;len<=n;len++){
            for(int start=1;start<=n-len+1;start++){
                dp[start][start+len-1]=Integer.MAX_VALUE;
                for(int pivot=start+(len-1)/2;pivot<start+len-1;pivot++){
                    dp[start][start+len-1]=Math.min(dp[start][start+len-1],pivot+Math.max(dp[start][pivot-1],dp[pivot+1][start+len-1]));
                }
            }
        }
        return dp[1][n];
    }
}