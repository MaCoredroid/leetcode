class Solution {
    
    public int superEggDrop(int k, int n) {
        int[] dp=new int[n+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=i;
        }
        for(int j=2;j<=k;j++){
            int x=1;
            int[] dp2=new int[n+1];
            for(int m=1;m<=n;m++){
                while(x<m&&Math.max(dp[x-1],dp2[m-x])>Math.max(dp[x],dp2[m-x-1])){
                    x++;
                }
                dp2[m]=1+Math.max(dp[x-1],dp2[m-x]);
            }
            dp=dp2;
        }
        return dp[n];
    }

    
}