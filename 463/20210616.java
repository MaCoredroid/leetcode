class Solution {
    int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int islandPerimeter(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ans+=4;
                    for(int k=0;k<4;k++){
                        int nx=i+dirs[k][0];
                        int ny=j+dirs[k][1];
                        if(nx<0||nx>=grid.length||ny<0||ny>=grid[0].length||grid[nx][ny]!=1){
                            continue;
                        }
                        ans--;
                    }
                }
            }
        }
        return ans;
    }
}