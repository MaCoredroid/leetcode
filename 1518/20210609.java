class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res=numBottles;
        int ans=numBottles;
        while(res>=numExchange){
            ans+=res/numExchange;
            res=res%numExchange+res/numExchange;
        }
        return ans;
    }
}