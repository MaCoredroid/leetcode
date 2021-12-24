class Solution {
    public int shortestBridge(int[][] grid) {
        int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int m=grid.length,n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    grid[i][j]=2;
                    Queue<int[]> q=new LinkedList<>();
                    Queue<int[]> p=new LinkedList<>();
                    q.offer(new int[]{i,j});
                    p.offer(new int[]{i,j,0});
                    while(!q.isEmpty()){
                        int[] temp=q.poll();
                        for(int k=0;k<4;k++){
                            int nx=temp[0]+dirs[k][0];
                            int ny=temp[1]+dirs[k][1];
                            if(nx>=0&&nx<m&&ny>=0&&ny<n&&grid[nx][ny]==1){
                                grid[nx][ny]=2;
                                q.offer(new int[]{nx,ny});
                                p.offer(new int[]{nx,ny,0});
                            }
                        }
                    }
                    while(!p.isEmpty()){
                        int[] temp=p.poll();
                        for(int k=0;k<4;k++){
                            int nx=temp[0]+dirs[k][0];
                            int ny=temp[1]+dirs[k][1];
                            if(nx>=0&&nx<m&&ny>=0&&ny<n&&grid[nx][ny]!=2){
                                if(grid[nx][ny]==1){
                                    return temp[2];
                                }
                                grid[nx][ny]=2;
                                p.offer(new int[]{nx,ny,temp[2]+1});
                            }
                        }
                    }
                    break;
                }
                
            }
        }
        return -1;
    }
}