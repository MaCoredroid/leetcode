class Solution {
    int[] durations=new int[]{1,7,30};
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp=new int[days.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i=dp.length-1;i>=0;i--){
            int p=i;
            for(int j=0;j<3;j++){
                while(p<days.length&&days[p]<days[i]+durations[j]){
                    p++;
                }
                if(p<days.length) {
                    dp[i]=Math.min(dp[p]+costs[j],dp[i]);
                }else{
                    dp[i]=Math.min(costs[j],dp[i]);
                }
            }
        }
        return dp[0];
    }
}