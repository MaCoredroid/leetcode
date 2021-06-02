class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans=0;
        for(int[] account:accounts){
            int temp=0;
            for(int money:account){
                temp+=money;
            }
            ans=Math.max(ans,temp);
        }
        return ans;
    }
}