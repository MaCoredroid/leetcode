class Solution {
    HashMap<Integer,List<List<Integer>>> record=new HashMap<>();
    HashMap<Integer,List<Integer>> map=new HashMap<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int m=graph.length;
        int n=graph[0].length;
        for(int i=0;i<m;i++){
            List<Integer> next=new ArrayList<>();
            for(int j=0;j<graph[i].length;j++){
                next.add(graph[i][j]);
            }
            map.put(i,next);
        }
        return helper(0,m-1);

    }

    private List<List<Integer>> helper(int start,int end){
        if(start==end){
            List<List<Integer>> ret=new ArrayList<>();
            List<Integer> path=new ArrayList<>();
            path.add(end);
            ret.add(path);
            return ret;
        }
        if(!record.containsKey(start)){
            List<List<Integer>> ret=new ArrayList<>();
            if(map.containsKey(start)){
                List<Integer> next=map.get(start);
                for(Integer a:next){
                    List<List<Integer>> res=helper(a,end);
                    for(List<Integer> path:res){
                        List<Integer> copy=new ArrayList<>(path);
                        copy.add(0,start);
                        ret.add(copy);
                    }
                }
            }
            record.put(start,ret);
        }
        return record.get(start);
    }
}