class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->(o1[1]-o2[1]));
        List<int[]> res=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            if(res.size()==0||res.get(res.size()-1)[1]<intervals[i][0]){
                res.add(intervals[i]);
            }else{
                int left=Math.min(res.get(res.size()-1)[0],intervals[i][0]);
                res.remove(res.size()-1);
                while(res.size()>0&&left<=res.get(res.size()-1)[1]){
                    left=Math.min(res.get(res.size()-1)[0],left);
                    res.remove(res.size()-1);
                }
                res.add(new int[]{left,intervals[i][1]});
            }
        }
        int[][] ans=new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        return ans;
        
    }
}