class Solution {
    int maxArea=0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int[] ans=new int[]{0};
                    dfs(grid,i,j,ans);
                    maxArea=Math.max(maxArea,ans[0]);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, int i,int j,int[] ans){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length){
            return;
        }
        if(grid[i][j]==1){
            ans[0]++;
            grid[i][j]=0;
        }else{
            return;
        }
        dfs(grid,i+1,j,ans);
        dfs(grid,i-1,j,ans);
        dfs(grid,i,j+1,ans);
        dfs(grid,i,j-1,ans);

    }
}