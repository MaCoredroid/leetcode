class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int L = nums.length;
        int[] sum = new int[nums.length+1];

        for(int i = 0; i < L; i++) {
            sum[i+1] = sum[i]+nums[i];
        }
        int[][] dp = new int[4][L+1];
        for(int i = 1; i < 4; i++) {
            for(int j = k; j <= L; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-k] + sum[j]-sum[j-k]);
            }
        }

        int[] ret = new int[3];
        int max = Arrays.stream(dp[3]).max().getAsInt();
        for(int i=3;i>0;i--){
            for(int j=1;j<=L;j++){
                if(dp[i][j]==max){
                    ret[i-1]=j-k;
                    max -= sum[j]-sum[j-k];
                }
            }
        }
        return ret;
    }
}