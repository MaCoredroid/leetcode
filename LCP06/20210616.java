class Solution {
    public int minCount(int[] coins) {
        int ans=0;
        for(int coin:coins){
            ans+=(coin-1)/2+1;
        }
        return ans;
    }
}