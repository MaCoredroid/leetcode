class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m=Math.max(matrix.length,matrix[0].length);
        int[] res=new int[2*m+1];
        Arrays.fill(res,-1);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(res[i-j+m]!=-1&&res[i-j+m]!=matrix[i][j]){
                    return false;
                }
                res[i-j+m]=matrix[i][j];
            }
        }
        return true;
    }
}