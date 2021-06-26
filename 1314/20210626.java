class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] pre=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                pre[i+1][j+1]=pre[i][j+1]+pre[i+1][j]-pre[i][j]+mat[i][j];
            }
        }
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int maxI=i+k+1>m?m:i+k+1;
                int maxJ=j+k+1>n?n:j+k+1;
                int minI=i-k>=0?i-k:0;
                int minJ=j-k>=0?j-k:0;
                ans[i][j]=pre[maxI][maxJ]-pre[maxI][minJ]-pre[minI][maxJ]+pre[minI][minJ];
            }
        }
        return ans;
    }
}