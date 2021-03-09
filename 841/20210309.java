class Solution {
    int count=0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] res=new boolean[rooms.size()];
        res[0]=true;
        count=rooms.size()-1;
        dfs(res,rooms,0);
        return count==0;
    }

    private void dfs(boolean[] res,List<List<Integer>> rooms,int start){
        List<Integer> keys=rooms.get(start);
        for(Integer key:keys){
            if(!res[key]){
                count--;
                res[key]=true;
                dfs(res,rooms,key);
            }
        }
    }
}