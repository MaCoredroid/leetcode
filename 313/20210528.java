class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1){
            return 1;
        }
        int[] dp=new int[n];
        dp[0]=1;
        int[] pointers=new int[primes.length];
        for(int i=1;i<n;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                int num=primes[j]*dp[pointers[j]];
                dp[i]=Math.min(dp[i],num);
            }
            for(int j=0;j<primes.length;j++){
                int num=primes[j]*dp[pointers[j]];
                if(dp[i]==num){
                    pointers[j]++;
                }
            }
        }
        return dp[n-1];

    }
}