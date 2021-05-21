class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD = 1_000_000_000 + 7;
        int[][] dp=new int[n+1][minProfit+1];
        dp[0][0]=1;
        for(int i=0;i<group.length;i++){
            int people=group[i];
            int money=profit[i];
            for(int j=n;j>=people;j--){
                for(int k=minProfit;k>=0;k--){
                    dp[j][k]+=k-money>=0?dp[j-people][k-money]:dp[j-people][0];
                    if(dp[j][k]>=MOD){
                        dp[j][k]-=MOD;
                    }
                }
            }
        }
        int ret=0;
        for(int i=0;i<=n;i++){
            ret+=dp[i][minProfit];
            if(ret>=MOD){
                ret-=MOD;
            }
        }
        return ret;
    }
}