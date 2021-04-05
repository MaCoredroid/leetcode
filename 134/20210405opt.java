class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i=0;
        while(i<gas.length){
            int count=0;
            int cnt=0;
            while(cnt<gas.length){
                int j=(i+cnt)%gas.length;
                count+=gas[j];
                count-=cost[j];
                if(count<0){
                    break;
                }
                cnt++;
            }
            if(cnt!=gas.length){
                i=i+cnt+1;
                continue;
            }else{
                return i;
            }
            
        }
        return -1;
    }
}