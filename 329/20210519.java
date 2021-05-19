class Solution {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        dp=new int[matrix.length][matrix[0].length];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int ret=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                ret=Math.max(helper(matrix,i,j),ret);
            }
        }
        return ret;

    }

    public int helper(int[][] matrix,int i,int j){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(i>0&&matrix[i-1][j]>matrix[i][j]){
            ans=Math.max(helper(matrix,i-1,j),ans);
        }
        if(i+1<matrix.length&&matrix[i+1][j]>matrix[i][j]){
            ans=Math.max(helper(matrix,i+1,j),ans);
        }
        if(j>0&&matrix[i][j-1]>matrix[i][j]){
            ans=Math.max(helper(matrix,i,j-1),ans);
        }
        if(j+1<matrix[0].length&&matrix[i][j+1]>matrix[i][j]){
            ans=Math.max(helper(matrix,i,j+1),ans);
        }
        dp[i][j]=ans+1;
        return ans+1;

    }
}