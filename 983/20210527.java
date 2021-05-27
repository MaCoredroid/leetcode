class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp=new int[days.length];
        int[] durations = new int[]{1, 7, 30};
        for(int i=days.length-1;i>=0;i--){
            dp[i]=Integer.MAX_VALUE;
            for(int j=0;j<3;j++){
                int p=i;
                while(p<days.length&&days[i]+durations[j]>days[p]){
                    p++;
                }
                dp[i]=Math.min(dp[i],costs[j]+(p>=days.length?0:dp[p]));
            }
        }
        return dp[0];
    }
}