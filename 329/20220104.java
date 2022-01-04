class Solution {
    int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    int m,n;
    public int longestIncreasingPath(int[][] matrix) {
        this.m=matrix.length;
        this.n=matrix[0].length;
        int[][] cache=new int[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans=Math.max(ans,dfs(matrix,i,j,cache));
            }
        }
        return ans;
    }
    
    public int dfs(int[][] matrix,int i,int j,int[][] cache){
        if(cache[i][j]>0) return cache[i][j];
        for(int k=0;k<4;k++){
            int newX=i+dirs[k][0];
            int newY=j+dirs[k][1];
            if(newX>=0&&newX<m&&newY>=0&&newY<n&&matrix[newX][newY]>matrix[i][j]){
                cache[i][j]=Math.max(cache[i][j],dfs(matrix,newX,newY,cache));
            }
        }
        return ++cache[i][j];
    }
}