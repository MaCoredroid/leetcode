class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans=new ArrayList<>();
        int left=newInterval[0];
        int right=newInterval[1];
        boolean placed=false;
        for(int[] interval:intervals){
            if(interval[0]>right){
                if(!placed){
                    ans.add(new int[]{left,right});
                    placed=true;
                }
                ans.add(interval);
            }else if(interval[1]<left){
                ans.add(interval);
            }else{
                left=Math.min(left,interval[0]);
                right=Math.max(right,interval[1]);
            }
        }
        if(!placed){
            ans.add(new int[]{left,right});
        }
        return ans.toArray(new int[ans.size()][2]);


    }
}