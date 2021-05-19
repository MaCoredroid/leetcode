class Solution {
    public int[] constructArr(int[] a) {
        if(a.length==0){
            return new int[0];
        }
        int[] dp=new int[a.length];
        dp[0]=a[0];
        for(int i=1;i<a.length;i++){
            dp[i]=dp[i-1]*a[i];
        }
        int[] dp1=new int[a.length];
        dp1[a.length-1]=a[a.length-1];
        for(int i=a.length-2;i>=0;i--){
            dp1[i]=dp1[i+1]*a[i];
        }
        int[] ret=new int[a.length];
        ret[0]=dp1[1];
        ret[ret.length-1]=dp[dp.length-2];
        for(int i=1;i<ret.length-1;i++){
            ret[i]=dp[i-1]*dp1[i+1];
        }
        return ret;
    }
}