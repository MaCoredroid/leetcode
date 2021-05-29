class Solution {
    int mod = 1000000007;
    public int[] solve(int[] nums, int[][] queries) {
        int n=nums.length;
        int[] ret=new int[queries.length];
        if(n<200){
            for(int i=0;i<queries.length;i++){
                ret[i]=helper(nums,queries[i][0],queries[i][1]);
            }
            return ret;
        }
        int sqrtLen = (int)(Math.sqrt(n) /4);
        int[][] dp=new int[n][sqrtLen+1];
        for(int j=1;j<=sqrtLen;j++){
            for(int i=n-1;i>=0;i--){
                dp[i][j]=(nums[i]%mod+(i+j>=n?0:dp[i+j][j])%mod)%mod;
            }
        }
        for(int i=0;i<queries.length;i++){
            if(queries[i][1]<=sqrtLen){
                ret[i]=dp[queries[i][0]][queries[i][1]];
            }else{
                ret[i]=helper(nums,queries[i][0],queries[i][1]);
            }
        }
        return ret;
    }

    private int helper(int[] nums,int x,int y){
        long sum=0;
        for(int i=x;i<nums.length;i+=y){
            sum=(sum+nums[i])%mod;
        }
        return (int)sum%mod;
    }
}