class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy=prices[0]+fee;
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]+fee<buy){
                buy=prices[i]+fee;
            }else if(prices[i]>buy){
                profit+=prices[i]-buy;
                buy=prices[i];
            }
        }
        return profit;
    }
}