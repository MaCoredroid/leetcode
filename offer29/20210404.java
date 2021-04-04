class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return new int[0];
        }
        int len=matrix.length*matrix[0].length;
        int[] ans=new int[len];
        int up=0;
        int down=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        int count=0;
        while(count<len){
            for(int i=left;i<=right;i++){
                ans[count++]=matrix[up][i];
            }
            up++;
            if(count>=ans.length){
                break;
            }
            for(int i=up;i<=down;i++){
                ans[count++]=matrix[i][right];
            }
            right--;
            if(count>=ans.length){
                break;
            }
            for(int i=right;i>=left;i--){
                ans[count++]=matrix[down][i];
            }
            down--;
            if(count>=ans.length){
                break;
            }
            for(int i=down;i>=up;i--){
                ans[count++]=matrix[i][left];
            }
            left++;
            if(count>=ans.length){
                break;
            }
        }
        return ans;
    }
}