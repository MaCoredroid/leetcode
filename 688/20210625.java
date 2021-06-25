class Solution {
    int[][] dirs=new int[][]{{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][] dp=new double[n][n];
        dp[row][column]=1;
        for(;k>0;k--){
            double[][] dp2=new double[n][n];
            for(int r=0;r<n;r++){
                for(int c=0;c<n;c++){
                    for(int p=0;p<8;p++){
                        int nx=r+dirs[p][0];
                        int ny=c+dirs[p][1];
                        if(nx>=0&&nx<n&&ny>=0&&ny<n){
                            dp2[nx][ny]+=dp[r][c]/8.0;
                        }
                    }
                }
            }
            dp=dp2;
        }
        double ans = 0.0;
        for (double[] r: dp) {
            for (double x: r) ans += x;
        }
        return ans;
    }
}