class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][][] visited=new boolean[m][n][k+1];
        Queue<int[]> queue=new LinkedList<>();
        int[][] dirs=new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        queue.offer(new int[]{0,0,grid[0][0],1});
        
        while(!queue.isEmpty()){
            int[] temp=queue.poll();
            if(temp[0]==m-1&&temp[1]==n-1){
                return temp[3]-1;
            }
            for(int i=0;i<4;i++){
                int nx=temp[0]+dirs[i][0];
                int ny=temp[1]+dirs[i][1];
                if(nx<0||nx>=m||ny<0||ny>=n){
                    continue;
                }
                if(temp[2]+grid[nx][ny]>k){
                    continue;
                }
                if(visited[nx][ny][temp[2]+grid[nx][ny]]){
                    continue;
                }
                visited[nx][ny][temp[2]+grid[nx][ny]]=true;
                queue.offer(new int[]{nx,ny,temp[2]+grid[nx][ny],temp[3]+1});
            }
        }
        return -1;
    }
}