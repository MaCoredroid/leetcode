class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            edges.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            edges.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] visited=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(!dfs(visited,edges,i)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[] visited,List<List<Integer>> edges,int course){
        visited[course]=1;
        List<Integer> edge=edges.get(course);
        for(int i=0;i<edge.size();i++){
            if(visited[edge.get(i)]==1){
                return false;
            }else if(visited[edge.get(i)]==0){
                if(!dfs(visited,edges,edge.get(i))){
                    return false;
                }
            }
        }
        visited[course]=2;
        return true;
    }
}