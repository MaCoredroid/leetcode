class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        int sqrtMin=(int)Math.sqrt(n)+1;
        int[] square=new int[sqrtMin+1];
        for(int i=0;i<=sqrtMin;i++){
            square[i]=i*i;
        }
        for(int i=1;i<=n;i++){
            int temp=1;
            while(square[temp]<=i){
                dp[i]=Math.min(dp[i],dp[i-square[temp]]+1);
                temp++;
            }
        }
        return dp[n];
    }
}