class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<prices.length;i++)
        {
            maxProfit=Math.max(maxProfit,prices[i]-minPrice);
            minPrice=Math.min(prices[i],minPrice);
        }
        return maxProfit;
       
    }
}