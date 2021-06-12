class Solution {
    int[][] grid;
    int[] area;
    int N;
    int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int largestIsland(int[][] grid) {
        N=grid.length;
        int[] area=new int[N*N+2];
        this.grid=grid;
        int index=2;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j]==1){
                    area[index]=dfs(i,j,index);
                    index++;
                }
            }
        }
        int ans = 0;
        for (int x: area) ans = Math.max(ans, x);
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j]==0){
                    Set<Integer> seen=new HashSet<>();
                    for(int k=0;k<4;k++){
                        int nx=i+dirs[k][0];
                        int ny=j+dirs[k][1];
                        if(nx<0||nx>=N||ny<0||ny>=N||grid[nx][ny]<=1){
                            continue;
                        }
                        seen.add(grid[nx][ny]);
                    }
                    int bns=1;
                    for(Integer pointer:seen){
                        bns+=area[pointer];
                    }
                    ans=Math.max(ans,bns);
                }
            }
        }
        return ans;

    }

    private int dfs(int x,int y,int index){
        int ans=1;
        grid[x][y]=index;
        for(int i=0;i<4;i++){
            int nx=x+dirs[i][0];
            int ny=y+dirs[i][1];
            if(nx<0||nx>=N||ny<0||ny>=N||grid[nx][ny]!=1){
                continue;
            }
            ans+=dfs(nx,ny,index);
        }
        return ans;
    }
}