class Solution {
    int[][] dirs=new int[][]{{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0]==1){
            return -1;
        }
        grid[0][0]=1;
        Queue<int[]> pq=new LinkedList<>();
        pq.offer(new int[]{0,0});
        int step=1;
        if(m==1&&n==1){
            return step;
        }
        while(!pq.isEmpty()){
            int size=pq.size();
            for(int j=0;j<size;j++){
                int[] temp=pq.poll();
                for(int i=0;i<8;i++){
                    int nx=temp[0]+dirs[i][0];
                    int ny=temp[1]+dirs[i][1];
                    if(nx<0||nx>=m||ny<0||ny>=n){
                        continue;
                    }
                    if(grid[nx][ny]==1){
                        continue;
                    }
                    if(nx==m-1&&ny==n-1){
                        return step+1;
                    }
                    pq.offer(new int[]{nx,ny});
                    grid[nx][ny]=1;
                }
            }
            step++;
        }
        return -1;
    }
}