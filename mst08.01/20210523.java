class Solution {
    public int waysToStep(int n) {
        if(n<=2){
            return n;
        }
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=((dp[i-3]+dp[i-2])%1000000007+dp[i-1]%1000000007)%1000000007;
        }
        return dp[n];
    }
}