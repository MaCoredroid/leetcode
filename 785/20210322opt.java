class Solution {
    int[][] res;
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    public boolean isBipartite(int[][] graph) {
        res=graph;
        color=new int[graph.length];
        Arrays.fill(color,UNCOLORED);
        for(int i=0;i<graph.length;i++){
            if(color[i]==UNCOLORED){
                if(!dfs(RED,i)){
                    return false;
                }
            }
        }
        
        return true;
    }

    private boolean dfs(int value,int pointer){
        color[pointer]=value;
        int[] ret=res[pointer];
        int cNei = value == RED ? GREEN : RED;
        for(int i=0;i<ret.length;i++){
            if(color[ret[i]]==UNCOLORED){
                if(!dfs(cNei,ret[i])){
                    return false;
                }
            }else if(color[ret[i]]==value){
                return false;
            }
        }
            
       
        return true;
    }
}