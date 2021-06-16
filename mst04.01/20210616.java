class Solution {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int[] edge:graph){
            List<Integer> ans=map.getOrDefault(edge[0],new ArrayList<>());
            ans.add(edge[1]);
            map.put(edge[0],ans);
        }
        return dfs(map,start,target);
    }

    private boolean dfs(HashMap<Integer,List<Integer>> map,int start,int target){
        List<Integer> ans=map.getOrDefault(start,new ArrayList<>());
        List<Integer> res=new ArrayList<>(ans);
        for(Integer next:ans){
            if(next==target){
                return true;
            }
            if(dfs(map,next,target)){
                return true;
            }else{
                res.remove(next);
                map.put(start,res);
            }
        }
        return false;
    }
}