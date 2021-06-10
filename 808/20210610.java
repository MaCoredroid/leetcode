class Solution {
    public double soupServings(int n) {
        if(n==0){
            return 0.5;
        }
        n=(n-1)/25+1;
        if(n>=500){
            return 1.0;
        }
        double[][] dp=new double[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                double ans=0;
                if(i==0){
                    ans=1.0;
                }
                if(i==0&&j==0){
                    ans=0.5;
                }
                if(i>0&&j>0){
                    ans=0.25*(dp[M(i-4)][j]+dp[M(i-3)][M(j-1)]+dp[M(i-2)][M(j-2)]+dp[M(i-1)][M(j-3)]);
                }
                dp[i][j]=ans;
            }
        }
        return dp[n][n];
    }

    public int M(int x){
        return x<0?0:x;
    }
}