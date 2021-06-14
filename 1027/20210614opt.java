class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][2000];
        int res=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int diff=nums[i]-nums[j];
                dp[i][1000+diff] = Math.max(dp[i][1000+diff], dp[j][1000+diff] + 1);
                res=Math.max(res,dp[i][1000+diff]);
            }
        }
        return res+1;
    }
}