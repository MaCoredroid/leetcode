class Solution {
    boolean[][] visited;
    int m=0;
    int n=0;
    List<List<Integer>> ans=new ArrayList<>();
    int[][] dirs=new int[][]{{0,1},{1,0}};
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        m=obstacleGrid.length;
        n=obstacleGrid[0].length;
        visited=new boolean[m][n];
        dfs(obstacleGrid,0,0,new ArrayList<>());
        return ans;
    }

    private void dfs(int[][] obstacleGrid,int i,int j,List<List<Integer>> temp){
        if(obstacleGrid[i][j]==1||visited[i][j]){
            return;
        }
        visited[i][j]=true;
        temp.add(new ArrayList<>());
        temp.get(temp.size()-1).add(i);
        temp.get(temp.size()-1).add(j);
        if(i==m-1&&j==n-1){
            ans=new ArrayList<>(temp);
            return;
        }
        for(int k=0;k<2;k++){
            int nx=i+dirs[k][0];
            int ny=j+dirs[k][1];
            if(nx<0||nx>=m||ny<0||ny>=n){
                continue;
            }
            dfs(obstacleGrid,nx,ny,temp);
        }
        temp.remove(temp.size()-1);

    }
}