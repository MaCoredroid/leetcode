class Solution {
    public int strangePrinter(String s) {
        if(s==null||s.length()==0) return 0;
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(j==i){
                    dp[i][j]=1;
                }else if(j==i+1){
                        if(s.charAt(i)==s.charAt(j)){
                            dp[i][j]=1;
                        }else{
                            dp[i][j]=2;
                        }
                    }
                else{
                    dp[i][j]=Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j]);
                    }
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]--;
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}