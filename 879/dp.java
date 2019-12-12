class Solution {
    
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int MOD = 1000_000_007;
        int N= group.length;
        long [][][] dp= new long[2][P+1][G+1];
        dp[0][0][0] = 1;
        for(int i=0; i<N; i++)
        {
            int p0 = profit[i];
            int g0 = group[i];
            long [][] cur = dp[i%2];
            long [][] cur2 = dp[(i+1)%2];
            for(int jp =0;jp<=P;jp++)//deep copy
            {
                for(int  jg=0;jg<=G;jg++)
                {
                    cur2[jp][jg] = cur[jp][jg];
                }
            }
            for(int p1=0;p1 <=P;p1++)// p1 is the current profit
            {
                int p2= Math.min(p1+p0, P);
                for(int g1=0;g1<=G-g0;g1++)//g1 the current group size
                {//g2 the new grouping size
                    int g2 = g1 + g0;
                    cur2[p2][g2]+=cur[p1][g1];
                    cur2[p2][g2]%=MOD;
                }
            }
        }
        long ans=0;
        for(long x:dp[N%2][P])
        {
            ans +=x;
        }
        return (int) ans;
    }
}