class Solution {
    public int strangePrinter(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        char[] ch=s.toCharArray();
        for(int i=n-1;i>=0;i--){
            dp[i][i]=1;
            for(int j=i+1;j<n;j++){
                if(ch[i]==ch[j]){
                    dp[i][j]=dp[i][j-1];
                }
                else{
                    int ans=Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        ans=Math.min(ans,dp[i][k]+dp[k+1][j]);
                    }
                    dp[i][j]=ans;
                }
            }
        }
        return dp[0][n-1];
    }
}