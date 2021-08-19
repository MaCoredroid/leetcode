class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] visited=new int[numCourses];
        for(int[] prerequisite:prerequisites){
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0&&!isCycle(visited,graph,i)){
                return false;
            }
        }
        return true;
    }
    
    private boolean isCycle(int[] visited,List<List<Integer>> graph,int target){
        visited[target]=1;
        for(Integer next:graph.get(target)){
            if(visited[next]==1){
                return false;
            }else if(visited[next]==0){
                if(!isCycle(visited,graph,next)){
                    return false;
                }
            }
        }
        visited[target]=2;
        return true;
    }
}