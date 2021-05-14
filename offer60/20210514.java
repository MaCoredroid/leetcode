class Solution {
    public double[] dicesProbability(int n) {
        int[][] dp=new int[n+1][6*n+1];
        for(int i=1;i<=6;i++){
            dp[1][i]=1;
        }
        for(int i=2;i<dp.length;i++){
            for(int j=i;j<=6*i;j++){
                for(int cur=1;cur<=6;cur++){
                    if(j-cur<=0){
                        break;
                    }
                    dp[i][j]+=dp[i-1][j-cur];
                }
            }
        }
        double all=Math.pow(6,n);
        double[] ans=new double[5*n+1];
        for(int i=n;i<=6*n;i++){
            ans[i-n]=dp[n][i]/all;
        }
        return ans;
    }

    
}