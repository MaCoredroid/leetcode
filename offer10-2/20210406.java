class Solution {
    public int numWays(int n) {
        if(n<=1){
            return 1;
        }
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-1]%1_000_000_007+dp[i-2]%1_000_000_007)%1_000_000_007;
        }
        return dp[n];
    }
}