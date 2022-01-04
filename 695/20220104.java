class Solution {
    int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    int m;
    int n;
    public int maxAreaOfIsland(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    ans=Math.max(ans,dfs(grid,i,j));
                }
            }
        }
        return ans;
    }
    
    public int dfs(int[][] grid,int i,int j){
        if(grid[i][j]!=1) return 0;
        grid[i][j]=-1;
        int ans=1;
        for(int k=0;k<4;k++){
            int newX=i+dirs[k][0];
            int newY=j+dirs[k][1];
            if(newX>=0&&newX<m&&newY>=0&&newY<n&&grid[newX][newY]==1){
                ans+=dfs(grid,newX,newY);
            }
        }
        return ans;
    }
}