class Solution {
    static final int MOD = 1000000007;
    public int numOfWays(int n) {
        long val1=6,val2=6;
        for(int i=2;i<=n;i++){
            long temp1=(2L * val1+2L * val2)%MOD;
            long temp2=(2L * val1+3L * val2)%MOD;
            val1=temp1;
            val2=temp2;
        }
        return (int)(val1+val2)%MOD;
    }

    
}