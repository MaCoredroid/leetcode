class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int left=matrix[0][0];
        int right=matrix[n-1][n-1];
        while(left<right){
            int mid=left+((right-left)>>1);
            if(verify(matrix,k,mid,n)){
                left=mid+1;
            }else{
                right=mid;
            }

        }
        return left;
    }

    private boolean verify(int[][] matrix, int k,int mid,int n){
        int i=n-1;
        int j=0;
        int count=0;
        while(j<n&&i>=0){
            if(matrix[i][j]<=mid){
                j++;
                count+=i+1;
            }else{
                i--;
            }
        }
        return count<k;
    }
}