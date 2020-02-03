class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][3][2];
        if(n==0)
        {
            return 0;
        }
        for(int i=0;i<n;i++)
        {
            
            if(i-1==-1)
            {
                dp[i][1][0]=0;
                dp[i][1][1]=-prices[0];
                dp[i][2][0]=0;
                dp[i][2][1]=-prices[0];
                continue;
            }
            dp[i][2][0]=Math.max(dp[i-1][2][0],dp[i-1][2][1]+prices[i]);
            dp[i][2][1]=Math.max(dp[i-1][2][1],dp[i-1][1][0]-prices[i]);
            dp[i][1][0]=Math.max(dp[i-1][1][0],dp[i-1][1][1]+prices[i]);
            dp[i][1][1]=Math.max(dp[i-1][1][1],-prices[i]);
            
        }
        return Math.max(dp[n-1][2][0],dp[n-1][1][0]);
    }
}