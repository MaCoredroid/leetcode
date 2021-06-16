class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] graph=new boolean[numCourses][numCourses];
        for(int[] p:prerequisites){
            graph[p[0]][p[1]]=true;
        }
        for (int k = 0; k < numCourses; ++k)
        {
            for (int i = 0; i < numCourses; ++i)
            {
                for (int j = 0; j < numCourses; ++j)
                {
                    if (graph[i][k] && graph[k][j])
                    {
                        graph[i][j] = true; 
                    }
                }
            }
        }
        List<Boolean> ret=new ArrayList<>();
        for(int[] query:queries){
            if(graph[query[0]][query[1]]){
                ret.add(true);
            }else{
                ret.add(false);
            }
        }
        return ret;
    }
}