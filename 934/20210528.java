class Solution {
    int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int shortestBridge(int[][] grid) {
        Queue<int[]> source=new LinkedList<>();
        Queue<int[]> target=new LinkedList<>();
        Set<Integer> set = new HashSet();
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        boolean flag=false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j]&&grid[i][j]==1){
                    if(!flag){
                        dfs(source,visited,grid,i,j);
                        flag=true;
                    }else{
                        dfs(target,visited,grid,i,j);
                    }
                }
                visited[i][j]=true;
            }
        }
        while(!target.isEmpty()){
            int[] temp=target.poll();
            set.add(temp[0]*grid[0].length+temp[1]);
        }
        while(!source.isEmpty()){
            int[] temp=source.poll();
            for(int i=0;i<4;i++){
                int nx=temp[0]+dirs[i][0];
                int ny=temp[1]+dirs[i][1];
                if(nx<0||nx>=grid.length||ny<0||ny>=grid[0].length){
                    continue;
                }
                if(set.contains(nx*grid[0].length+ny)){
                    return temp[2];
                }
                if(grid[nx][ny]==0){
                    grid[nx][ny]=1;
                    source.offer(new int[]{nx,ny,temp[2]+1});
                }
            }
        }
        return -1;
    }

    private void dfs(Queue<int[]> res,boolean[][] visited,int[][] grid,int i,int j){
        if(i<0||i>=visited.length||j<0||j>=visited[0].length){
            return;
        }
        if(visited[i][j]||grid[i][j]==0){
            return;
        }
        visited[i][j]=true;
        res.offer(new int[]{i,j,0});
        for(int p=0;p<4;p++){
            int nx=i+dirs[p][0];
            int ny=j+dirs[p][1];
            dfs(res,visited,grid,nx,ny);
        }
    }
}