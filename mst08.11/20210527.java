class Solution {
    int[] res=new int[]{25,10,5,1};
    static final int MOD = 1000000007;
    public int waysToChange(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int k=0;k<4;k++){
            int coin=res[k];
            for(int i=coin;i<=n;i++){
                dp[i]=(dp[i]+dp[i-coin])%MOD;
            }
        }
        return dp[n];

    }
}