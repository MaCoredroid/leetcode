class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++){
            int count=0;
            int j=i;
            while(j<gas.length){
                count+=gas[j];
                count-=cost[j];
                if(count<0){
                    break;
                }
                j++;
            }
            if(j!=gas.length){
                continue;
            }
            j=0;
            while(j<i){
                count+=gas[j];
                count-=cost[j];
                if(count<0){
                    break;
                }
                j++;
            }
            if(j==i){
                return i;
            }
        }
        return -1;
    }
}