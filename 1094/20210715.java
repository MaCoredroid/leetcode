class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] increment=new int[1002];
        for(int i=0;i<trips.length;i++){
            int start=Math.min(trips[i][1],trips[i][2]);
            int end=Math.max(trips[i][1],trips[i][2]);
            increment[start]+=trips[i][0];
            increment[end]-=trips[i][0];
        }
        int value=0;
        for(int i=0;i<increment.length;i++){
            value+=increment[i];
            if(value>capacity){
                return false;
            }
        }
        return true;
    }
}