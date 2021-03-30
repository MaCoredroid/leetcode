class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][2];
        }
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] interval1,int[] interval2){
                return interval1[0]-interval2[0];
            }
        }); 
        int[][] ans=new int[intervals.length][2];
        int pointer=-1;
        int curr=0;
        while(curr<intervals.length){
            if(pointer==-1||ans[pointer][1]<intervals[curr][0]){
                ans[++pointer]=intervals[curr];
            }else{
                ans[pointer][1]=Math.max(ans[pointer][1],intervals[curr][1]);
            }
            curr++;
        }
        return Arrays.copyOf(ans,pointer+1);
    }
        
}