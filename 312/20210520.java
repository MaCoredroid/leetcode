class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+2][n+2];
        int[] val=new int[n+2];
        val[0]=val[val.length-1]=1;
        for(int i=1;i<=n;i++){
            val[i]=nums[i-1];
        }
        for(int i=val.length-1;i>=0;i--){
            for(int j=i+2;j<val.length;j++){
                for(int k=i+1;k<j;k++){
                    int sum=val[k]*val[i]*val[j];
                    sum+=dp[i][k]+dp[k][j];
                    dp[i][j]=Math.max(dp[i][j],sum);
                }
            }
        }
        return dp[0][dp.length-1];
    }
}