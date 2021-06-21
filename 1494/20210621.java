class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] pre = new int[n];
        for(int[] depen: relations){
            pre[depen[0] - 1] |= 1 << (depen[1] - 1);
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for(int i=0;i<(1<<n);i++){
            int canStudy=0;
            for(int j=0;j<n;j++){
                if((i&(1<<j))==0&&(pre[j]&i)==pre[j]){
                    canStudy |= 1 << j;
                }
            }
            if(Integer.bitCount(canStudy) <= k){
                dp[i | canStudy] = Math.min(dp[i | canStudy], dp[i] + 1);
            } else {
                for(int cur = canStudy; cur > 0 ; cur = (cur - 1) & canStudy){ // 这行负责枚举所有的子集，可以好好消化下
                    if(Integer.bitCount(cur) <= k){
                        dp[i | cur] = Math.min(dp[i | cur], dp[i] + 1);
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}