class Solution {
    public int minDistance(String word1, String word2) {
        char[] ch1=word1.toCharArray();
        char[] ch2=word2.toCharArray();
        int n=ch1.length;
        int m=ch2.length;
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(ch1[i-1]==ch2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return m+n-2*dp[n][m];
    }
}