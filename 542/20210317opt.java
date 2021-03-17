class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] updateMatrix(int[][] matrix) {
        int[][] dp=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE/2);
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i-1>=0){
                    dp[i][j]=Math.min(dp[i-1][j]+1,dp[i][j]);
                }
                if(j-1>=0){
                    dp[i][j]=Math.min(dp[i][j-1]+1,dp[i][j]);
                }
            }
        }
        for(int i=matrix.length-1;i>=0;i--){
            for(int j=matrix[0].length-1;j>=0;j--){
                if(i+1<matrix.length){
                    dp[i][j]=Math.min(dp[i+1][j]+1,dp[i][j]);
                }
                if(j+1<matrix[0].length){
                    dp[i][j]=Math.min(dp[i][j+1]+1,dp[i][j]);
                }
            }
        }
        return dp;
    }
}