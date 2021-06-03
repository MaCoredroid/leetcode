class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int maxPrice = 1_000_000_000;
        int[][] dp=new int[n][k+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],maxPrice);
        }
        for(int i=0;i<=k;i++){
            dp[src][i]=0;
        }
        for(int[] flight:flights){
            if(flight[0]==src){
                dp[flight[1]][0]=flight[2];
            }
        }
        for(int i=1;i<=k;i++){
            for(int[] flight:flights){
                int from=flight[0];
                int to=flight[1];
                if(dp[from][i-1]!=maxPrice){
                    dp[to][i]=Math.min(dp[to][i],dp[from][i-1]+flight[2]);
                }
            }
        }
        return dp[dst][k]==maxPrice?-1:dp[dst][k];

    }
}