class Solution {
    public int islandPerimeter(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int cnt1=0,cnt2=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    cnt1++;
                    for(int k=0;k<4;k++){
                        int nx=i+dirs[k][0];
                        int ny=j+dirs[k][1];
                        if(nx>=0&&nx<m&&ny>=0&&ny<n&&grid[nx][ny]==1){
                            cnt2++;
                        }
                    }
                }
            }
        }
        return 4*cnt1-cnt2;
    }
}