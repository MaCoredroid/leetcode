class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] visited=new int[n];
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(isSafe(i,visited,graph)){
                ans.add(i);
            }
        }
        return ans;
    }
    
    public boolean isSafe(int i,int[] visited,int[][] graph){
        if(visited[i]!=0){
            if(visited[i]==1){
                return true;
            }
            return false;
        }
        visited[i]=2;
        for(int dest:graph[i]){
            if(!isSafe(dest,visited,graph)){
                return false;
            }
        }
        visited[i]=1;
        return true;
    }
}