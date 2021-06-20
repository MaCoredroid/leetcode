class Solution {
    public int nthUglyNumber(int n) {
        int p2=1;
        int p3=1;
        int p5=1;
        if(n==1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i]=Math.min(dp[p2]*2,dp[p3]*3);
            dp[i]=Math.min(dp[i],dp[p5]*5);
            if(dp[i]==dp[p2]*2){
                p2++;
            }
            if(dp[i]==dp[p3]*3){
                p3++;
            }
            if(dp[i]==dp[p5]*5){
                p5++;
            }
        }
        return dp[n];
    }
}