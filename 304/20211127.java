class NumMatrix {
    int[][] res;

    public NumMatrix(int[][] matrix) {
        res=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int up=i==0?0:res[i-1][j];
                int left=j==0?0:res[i][j-1];
                int topleft=((i>0&&j>0)?res[i-1][j-1]:0);
                res[i][j]=up+left-topleft+matrix[i][j];
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int top=row1-1>=0?res[row1-1][col2]:0;
        int left=col1-1>=0?res[row2][col1-1]:0;
        int topleft=(row1>0&&col1>0)?res[row1-1][col1-1]:0;
        return res[row2][col2]-top-left+topleft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */