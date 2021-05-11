class Solution {
    public int splitArray(int[] nums, int m) {
        int[][] dp=new int[nums.length+1][m+1];
        int[] sub=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            sub[i+1]=sub[i]+nums[i];
        }
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[0][0]=0;
        for(int i=1;i<=dp.length-1;i++){
            for(int j=1;j<=Math.min(i,m);j++){
                for(int k=0;k<i;k++){
                    dp[i][j]=Math.min(dp[i][j],Math.max(dp[k][j-1],sub[i]-sub[k]));
                }
            }
        }
        return dp[dp.length-1][m];
    }
}