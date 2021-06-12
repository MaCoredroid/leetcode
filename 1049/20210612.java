class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int stone:stones){
            sum+=stone;
        }
        int n=stones.length;
        int m=sum/2;
        boolean[][] dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(j<stones[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-stones[i-1]];
                }
            }
        }
        for(int j=m;j>=0;j--){
            if(dp[n][j]){
                return sum-2*j;
            }
        }
        return 0;
    }
}