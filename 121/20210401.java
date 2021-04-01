class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int min=prices[0];
        int ans=0;
        for(int i=0;i<prices.length;i++){
            min=Math.min(prices[i],min);
            ans=Math.max(ans,prices[i]-min);
        }
        return ans;
    }
}