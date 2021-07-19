class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> ans=new ArrayList<>();
        int index=-1;
        for(int i=heights.length-1;i>=0;i--){
            if(index==-1||heights[i]>heights[index]){
                ans.add(i);
                index=i;
            }
        }
        int[] ret=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            ret[i]=ans.get(ans.size()-1-i);
        }
        return ret;
    }
}