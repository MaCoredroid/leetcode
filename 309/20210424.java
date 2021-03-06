class Solution {
    public int maxProfit(int[] prices) {
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] dp=new int[prices.length][3];
        dp[0][0]=-prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][2]-prices[i],dp[i-1][0]);
            dp[i][1]=dp[i-1][0]+prices[i];
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]);
        }
        return Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);
    }
}