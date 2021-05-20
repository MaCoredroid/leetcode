class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp=new int[]{0,0,0};
        for(int num:nums){
            int a=dp[0]+num;
            int b=dp[1]+num;
            int c=dp[2]+num;
            dp[a%3]=Math.max(dp[a%3],a);
            dp[b%3]=Math.max(dp[b%3],b);
            dp[c%3]=Math.max(dp[c%3],c);
        }
        return dp[0];
    }
}