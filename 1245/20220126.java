class Solution {
    int max=0;
    public int treeDiameter(int[][] edges) {
        int n=edges.length;
        boolean[] visited=new boolean[n+1];
        if(edges.length==0) return 0;
        int start=edges[0][0];
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int[] e:edges){
            if(!map.containsKey(e[0])) map.put(e[0],new ArrayList<>());
            if(!map.containsKey(e[1])) map.put(e[1],new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        dfs(map,visited,start);
        return max;
    }
    
    public int dfs(Map<Integer,List<Integer>> map,boolean[] visited,int cur){
        visited[cur]=true;
        int res1=0,res2=0;
        for(int next:map.get(cur)){
            if(visited[next]) continue;
            int val=dfs(map,visited,next);
            if(val>res1){
                res2=res1;
                res1=val;
            }else if(val>res2){
                res2=val;
            }
        }
        
        max=Math.max(max,res1+res2);
        return res1+1;
    }
}