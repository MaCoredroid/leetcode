class Solution {
    public int palindromePartition(String s, int k) {
        int n=s.length();
        char[] ch=s.toCharArray();
        int[][] cost=new int[n][n];
        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                cost[i][j]=cost[i+1][j-1]+(ch[i]==ch[j]?0:1);
            }
        }
        int[][] dp=new int[n+1][k+1];
        for(int[] row:dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        dp[0][0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=Math.min(i,k);j++){
                if(j==1){
                    dp[i][j]=cost[0][i-1];
                }else{
                    for(int p=j-1;p<i;p++){
                        dp[i][j]=Math.min(dp[i][j],dp[p][j-1]+cost[p][i-1]);
                    }
                }
            }
        }
        return dp[n][k];
    }
}