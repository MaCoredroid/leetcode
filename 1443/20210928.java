class Solution {
    HashMap<Integer,List<Integer>> map=new HashMap<>();
    boolean[] visited;
    int count=0;
    List<Boolean> hasApple;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        visited=new boolean[n];
        this.hasApple=hasApple;
        for(int[] edge:edges){
            if(!map.containsKey(edge[0])){
                map.put(edge[0],new ArrayList<>());
            }
            if(!map.containsKey(edge[1])){
                map.put(edge[1],new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        dfs(0);
        return count==0?0:count-2;
    }
    
    private boolean dfs(int node){
        boolean flag=false;
        visited[node]=true;
        for(Integer next:map.get(node)){
            if(!visited[next]&&dfs(next)){
                flag=true; 
            }
        }
        if(hasApple.get(node)||flag){
            count+=2;
            return true;
        }
        return false;
        
    }
}