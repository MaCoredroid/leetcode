class Solution {
    int[][] dirs=new int[][]{{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0]==1){
            return -1;
        }
        boolean[][] visited=new boolean[m][n];
        visited[0][0]=true;
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->(o1[0]-o2[0]));
        pq.offer(new int[]{1,0,0});
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            if(temp[1]==m-1&&temp[2]==n-1){
                return temp[0];
            }
            for(int i=0;i<8;i++){
                int nx=temp[1]+dirs[i][0];
                int ny=temp[2]+dirs[i][1];
                if(nx<0||nx>=m||ny<0||ny>=n){
                    continue;
                }
                if(visited[nx][ny]||grid[nx][ny]==1){
                    continue;
                }
                pq.offer(new int[]{temp[0]+1,nx,ny});
                visited[nx][ny]=true;
            }
        }
        return -1;
    }
}