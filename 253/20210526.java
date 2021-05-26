class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }
        int[] start=new int[intervals.length];
        int[] end=new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int endpointer=0;
        int usedroom=0;
        for(int i=0;i<start.length;i++){
            if(end[endpointer]<=start[i]){
                endpointer++;
                usedroom--;
            }
            usedroom++;
        }
        return usedroom;
    }
}