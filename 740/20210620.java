class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    private int rob(int[] sum){
        int[] dp=new int[sum.length];
        for(int i=0;i<sum.length;i++){
            dp[i]=sum[i]+(i-2>=0?dp[i-2]:0);
            dp[i]=Math.max(dp[i],i-1>=0?dp[i-1]:0);
        }
        return dp[sum.length-1];
    }
}