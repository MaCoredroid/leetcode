class Solution {
    int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int ans=0;
    public int maxDistance(int[][] grid) {
        Queue<int[]> pq=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    pq.offer(new int[]{i,j,0});
                }
            }
        }
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            ans=Math.max(ans,temp[2]);
            for(int i=0;i<4;i++){
                int nx=temp[0]+dirs[i][0];
                int ny=temp[1]+dirs[i][1];
                if(nx<0||nx>=grid.length||ny<0||ny>=grid[0].length||grid[nx][ny]==1){
                    continue;
                }
                grid[nx][ny]=1;
                pq.offer(new int[]{nx,ny,temp[2]+1});
            }
        }
        return ans==0?-1:ans;
    }
}