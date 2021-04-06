class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i=matrix.length-1;
        int j=0;
        while(i>=0&&i<matrix.length&&j>=0&&j<matrix[0].length){
            int val=matrix[i][j];
            if(val==target){
                return true;
            }else if(val<target){
                j++;
            }else{
                i--;
            }
        }
        return false;
    }
    
}