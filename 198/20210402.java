class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] dp=new int[nums.length+1];
        dp[0]=nums[0];
        dp[1]=nums[1];
        int max=dp[0];
        for(int i=2;i<nums.length;i++){
            dp[i]=nums[i]+max;
            max=Math.max(max,dp[i-1]);
        }
        return Math.max(dp[nums.length-1],dp[nums.length-2]);
    }
}