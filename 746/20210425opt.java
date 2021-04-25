class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int first=cost[0];
        int second=cost[1];
        for(int i=2;i<cost.length;i++){
            int temp=first;
            first=second;
            second=Math.min(temp,second)+cost[i];
        }
        return Math.min(first,second);
    }
}