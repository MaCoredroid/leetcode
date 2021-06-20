class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(List<Integer> row:wall){
            int pre=0;
            for(int i=0;i<row.size()-1;i++){
                pre+=row.get(i);
                map.put(pre,map.getOrDefault(pre,0)+1);
            }
        }
        int ans=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            ans=Math.max(ans,entry.getValue());
        }
        return wall.size()-ans;
    }
}