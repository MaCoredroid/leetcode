class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m=mat.length;
        int n=mat[0].length;
        if(r*c!=m*n){
            return mat;
        }
        int[][] ret=new int[r][c];
        int p=0;
        int q=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ret[i][j]=mat[p][q];
                q++;
                if(q==n){
                    p++;
                    q=0;
                }
            }
        }
        return ret;
    }
}