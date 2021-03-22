class Solution {
    int[][] res;
    HashSet<Integer> black;
    HashSet<Integer> white;
    public boolean isBipartite(int[][] graph) {
        res=graph;
        black=new HashSet<>();
        white=new HashSet<>();
        for(int i=0;i<graph.length;i++){
            if(!black.contains(i)&&!white.contains(i)){
                black.add(i);
                if(!dfs(i,false)){
                    return false;
                }
            }
        }
        
        return true;
    }

    private boolean dfs(int pointer, boolean flag){
        int[] ret=res[pointer];
        if(ret.length==0){
            return true;
        }
        //put into white
        if(!flag){
            for(int i=0;i<ret.length;i++){
                if(!white.contains(ret[i])){
                    if(black.contains(ret[i])){
                        return false;
                    }
                    white.add(ret[i]);
                    if(!dfs(ret[i],!flag)){
                        return false;
                    }
                }
            }
            
        }else{
            for(int i=0;i<ret.length;i++){
                if(!black.contains(ret[i])){
                    if(white.contains(ret[i])){
                        return false;
                    }
                    black.add(ret[i]);
                    if(!dfs(ret[i],!flag)){
                        return false;
                    }
                }
            }

        }
        return true;
    }
}