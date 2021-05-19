class NumMatrix {
    int[][] pre;
    public NumMatrix(int[][] matrix) {
        pre=new int[matrix.length][matrix[0].length+1];
        for(int i=0;i<matrix.length;i++){
            int sum=0;
            for(int j=0;j<matrix[0].length;j++){
                pre[i][j+1]=sum+matrix[i][j];
                sum=pre[i][j+1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans=0;
        for(int i=row1;i<=row2;i++){
            ans+=pre[i][col2+1]-pre[i][col1];
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */