class Solution {
    int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> pq=new LinkedList<>();
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    cnt++;
                }else if(grid[i][j]==2){
                    pq.offer(new int[]{i,j,0});
                }
            }
        }
        int step=0;
        while(!pq.isEmpty()&&cnt>0){
            int[] temp=pq.poll();
            for(int i=0;i<4;i++){
                int nx=temp[0]+dirs[i][0];
                int ny=temp[1]+dirs[i][1];
                if(nx<0||nx>=m||ny<0||ny>=n||grid[nx][ny]!=1){
                    continue;
                }
                cnt--;
                pq.offer(new int[]{nx,ny,temp[2]+1});
                step=Math.max(step,temp[2]+1);
                grid[nx][ny]=2;
            }
        }
        if(cnt>0){
            return -1;
        }
        return step;
    }
}