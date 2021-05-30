class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int n=matrix[0].length;
        int i=matrix.length-1;
        int j=0;
        while(i>=0&&j<n){
            if(matrix[i][j]>target){
                i--;
            }else if(matrix[i][j]<target){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }
}