class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int current_tack=0;
        int total_tack=0;
        int start=0;
        for(int i=0;i<gas.length;i++)
        {
            current_tack+=gas[i]-cost[i];
            total_tack+=gas[i]-cost[i];
            if(current_tack<0)
            {
                current_tack=0;
                start=i+1;
            }
        }
        return total_tack<0?-1:start;
    }
}