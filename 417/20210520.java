class Solution {
    private List<List<Integer>> ans=new ArrayList<>();
    private boolean[][] dp;
    private int[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        dp=new boolean[m][n];
        boolean[][] temp=new boolean[m][n];
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(i==0||j==0){
                    dfs(heights,i,j,temp,true);
                }else{
                    break;
                }
            }
        }
        temp=new boolean[m][n];
        for(int i=heights.length-1;i>=0;i--){
            for(int j=heights[0].length-1;j>=0;j--){
                if(i==heights.length-1||j==heights[0].length-1){
                    dfs(heights,i,j,temp,false);
                }else{
                    break;
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] heights, int i,int j,boolean[][] visited,boolean flag){
        if(visited[i][j]){
            return;
        }
        if(flag){
            dp[i][j]=true;
            visited[i][j]=true;
            for(int p=0;p<4;p++){
                int x=i+dirs[p][0];
                int y=j+dirs[p][1];
                if(x>=0&&x<heights.length&&y>=0&&y<heights[0].length&&heights[x][y]>=heights[i][j]){
                    dfs(heights,x,y,visited,flag);
                }
            }
        }else{
            if(dp[i][j]){
                dp[i][j]=false;
                List<Integer> temp=new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
            }
            visited[i][j]=true;
            for(int p=0;p<4;p++){
                int x=i+dirs[p][0];
                int y=j+dirs[p][1];
                if(x>=0&&x<heights.length&&y>=0&&y<heights[0].length&&heights[x][y]>=heights[i][j]){
                    dfs(heights,x,y,visited,flag);
                }
            }
        }
    }
}