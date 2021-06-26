class Solution {
    int[][] dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public int getMaximumGold(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    ans=Math.max(ans,backTrack(grid,i,j));
                }
            }
        }
        return ans;
    }

    private int backTrack(int[][] grid,int i,int j){
        if(grid[i][j]==0){
            return 0;
        }
        int ans=0;
        int val=grid[i][j];
        grid[i][j]=0;
        for(int k=0;k<4;k++){
            int nx=i+dirs[k][0];
            int ny=j+dirs[k][1];
            if(nx<0||nx>=grid.length||ny<0||ny>=grid[0].length||grid[nx][ny]==0){
                continue;
            }
            ans=Math.max(ans,backTrack(grid,nx,ny));
        }
        grid[i][j]=val;
        return ans+val;
    }
}