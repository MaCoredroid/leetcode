class Solution {
    public int shortestPath(int[][] grid, int limit) {
        int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int m=grid.length;
        int n=grid[0].length;
        boolean[][][] visited=new boolean[m][n][limit+1];
        Queue<int[]> q=new LinkedList<>();
        visited[0][0][grid[0][0]]=true;
        q.offer(new int[]{0,0,grid[0][0],1});
        while(!q.isEmpty()){
            int[] res=q.poll();
            if(res[0]==m-1&&res[1]==n-1){
                return res[3]-1;
            }
            for(int k=0;k<4;k++){
                int nx=res[0]+dirs[k][0];
                int ny=res[1]+dirs[k][1];
                if(nx>=0&&nx<m&&ny>=0&&ny<n){
                    int val=res[2]+grid[nx][ny];
                    if(val<=limit&&!visited[nx][ny][val]){
                        visited[nx][ny][val]=true;
                        q.offer(new int[]{nx,ny,val,res[3]+1});
                    }
                }
            }
        }
        return -1;
        
    }
}