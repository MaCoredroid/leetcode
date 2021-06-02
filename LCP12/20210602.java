class Solution {
    public int minTime(int[] time, int m) {
        int left=0;
        int right=0;
        for(int times:time){
            right+=times;
        }
        while(left<=right){
            int middle=left+((right-left)>>1);
            if(check(time,m,middle)){
                right=middle-1;
            }else{
                left=middle+1;
            }
        }
        return left;
    }

    private boolean check(int[] time,int m,int limit){
        int totaltime=0,maxtime=0,group=1;
        for(int i=0;i<time.length;i++){
            int nextTime=Math.min(maxtime,time[i]);
            if(nextTime+totaltime<=limit){
                totaltime+=nextTime;
                maxtime=Math.max(maxtime,time[i]);
            }else{
                group++;
                if(group>m){
                    return false;
                }
                totaltime=0;
                maxtime=time[i];
            }

        }
        return group<=m;
    }
}