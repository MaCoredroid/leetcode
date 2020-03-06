class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)
        {
            return new int[0];
        }
        int[] ret=new int[matrix.length*matrix[0].length];
        int left=0;
        int right=matrix[0].length-1;
        int up=0;
        int down=matrix.length-1;
        int count=0;
        while(count<ret.length)
        {
            for(int i=left;i<=right;i++)
            {
                ret[count]=matrix[up][i];
                count++;
            }
            up++;
            if(down<up)
            {
                break;
            }
            for(int i=up;i<=down;i++)
            {
                ret[count]=matrix[i][right];
                count++;
            }
            right--;
            if(left>right)
            {
                break;
            }
            for(int i=right;i>=left;i--)
            {
                ret[count]=matrix[down][i];
                count++;
            }
            down--;
            if(up>down)
            {
                break;
            }
            for(int i=down;i>=up;i--)
            {
                ret[count]=matrix[i][left];
                count++;
            }
            left++;
        }
        return ret;
    }
}