class Solution {
    public int maximumSum(int[] arr) {
        int n=arr.length;
        int[][] dp=new int[n+1][2];
        int res=Integer.MIN_VALUE/2;
        dp[0][0]=Integer.MIN_VALUE/2;
        dp[0][1]=Integer.MIN_VALUE/2;
        for(int i=0;i<n;i++){
            dp[i+1][0]=dp[i][0]>0?dp[i][0]+arr[i]:arr[i];
            dp[i+1][1]=Math.max(dp[i][1]+arr[i],dp[i][0]);
            res=Math.max(res,dp[i+1][0]);
            res=Math.max(res,dp[i+1][1]);
        }
        return res;
    }
}