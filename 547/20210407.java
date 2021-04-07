class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited=new boolean[isConnected.length];
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                dfs(isConnected, visited,i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected,boolean[] visited ,int cur){
        visited[cur]=true;
        for(int i=0;i<isConnected[cur].length;i++){
            if(isConnected[cur][i]==1){
                if(!visited[i]){
                    dfs(isConnected,visited,i);
                }
            }
        }
    }
}