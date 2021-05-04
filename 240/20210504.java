class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length-1;
        int col=0;
        while(row>=0&&col<matrix[0].length&&matrix[row][col]!=target){
            if(matrix[row][col]>target){
                row--;
            }else{
                col++;
            }
        }
        return row>=0&&col<matrix[0].length&&matrix[row][col]==target;

    }
}