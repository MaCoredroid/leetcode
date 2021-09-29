class Solution {
    public int countVowelStrings(int n) {
        int[][] dp=new int[n+1][6];
        for(int i=1;i<=5;i++){
            dp[1][i]=i;
        }
        for(int i=2;i<=n;i++){
            dp[i][1]=1;
            for(int j=2;j<=5;j++){
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[n][5];
    }
    
    
}