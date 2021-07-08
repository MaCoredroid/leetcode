class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->(o1[0]-o2[0]));
        List<int[]> ans=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            if(ans.size()>0&&intervals[i][0]<=ans.get(ans.size()-1)[1]){
                ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],intervals[i][1]);
            }else{
                ans.add(intervals[i]);
            }
        }
        int[][] ret=new int[ans.size()][2];
        for(int i=0;i<ret.length;i++){
            ret[i]=ans.get(i);
        }
        return ret;
    }
}