class Solution {
    public int catMouseGame(int[][] graph) {
        int N=graph.length;
        final int DRAW=0,MOUSE=1,CAT=2;
        int[][][] color=new int[50][50][3];
        int[][][] degree=new int[50][50][3];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                degree[i][j][1]=graph[i].length;
                degree[i][j][2]=graph[j].length;
                for(int x:graph[j]){
                    if(x==0){
                        degree[i][j][2]--;
                        break;
                    }
                }
            }
        }
        
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int t=1;t<=2;t++){
                color[0][i][t]=MOUSE;
                queue.add(new int[]{0,i,t,MOUSE});
                if(i>0){
                    color[i][i][t] = CAT;
                    queue.add(new int[]{i, i, t, CAT});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] node=queue.poll();
            for(int[] parent: parents(graph,node[0],node[1],node[2])){
                if(color[parent[0]][parent[1]][parent[2]]==DRAW){
                    if(parent[2]==node[3]){
                        color[parent[0]][parent[1]][parent[2]]=parent[2];
                        queue.offer(new int[]{parent[0],parent[1],parent[2],parent[2]});
                    }else{
                        degree[parent[0]][parent[1]][parent[2]]--;
                        if(degree[parent[0]][parent[1]][parent[2]]==0){
                            color[parent[0]][parent[1]][parent[2]]=3-parent[2];
                            queue.offer(new int[]{parent[0],parent[1],parent[2],3-parent[2]});
                        }
                    }
                }
            }
        }
        
        
        return color[1][2][1];
    }
    
    public List<int[]> parents(int[][] graph, int m, int c, int t) {
        List<int[]> ans = new ArrayList();
        if (t == 2) {
            for (int m2: graph[m])
                ans.add(new int[]{m2, c, 3-t});
        } else {
            for (int c2: graph[c]) if (c2 > 0)
                ans.add(new int[]{m, c2, 3-t});
        }
        return ans;
    }
}