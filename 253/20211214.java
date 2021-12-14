class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->(o1[0]-o2[0]));
        List<int[]> res=new ArrayList<>();
        for(int[] temp:intervals){
            boolean flag=false;
            for(int[] next:res){
                if(next[1]<=temp[0]){
                    next[0]=temp[0];
                    next[1]=temp[1];
                    flag=true;
                    break;
                }
            }
            if(!flag){
                res.add(temp);
            }
        }
        return res.size();
    }
}