class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp=new int[n+1];
        int sum=0;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]*10 + (9*(int)Math.pow(10, i-2) - dp[i-1])*(i-1);
            sum+=dp[i];
        }
        return (int)Math.pow(10,n)-sum;
    }
}