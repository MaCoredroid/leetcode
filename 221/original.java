class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0)
        {
            return 0;
        }
        int ans=0;
        int[] left=new int[matrix[0].length];
        int[] right=new int[matrix[0].length];
        int[] height=new int[matrix[0].length];
        Arrays.fill(right,matrix[0].length);
        for(int i=0;i<matrix.length;i++)
        {
            int cur_left=0;
            int cur_right=matrix[0].length;
            for(int j=matrix[0].length-1;j>=0;j--)
            {
                if(matrix[i][j]=='1')
                {
                    right[j]=Math.min(right[j],cur_right);
                }
                else
                {
                    cur_right=j;
                    right[j]=matrix[0].length;
                }
            }
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]=='1')
                {
                    height[j]++;
                    left[j]=Math.max(left[j],cur_left);
                }
                else
                {
                    cur_left=j+1;
                    height[j]=0;
                    left[j]=0;
                }
                int temp=Math.min(height[j],right[j]-left[j]);
                ans=Math.max(ans,temp*temp);
            }
        }
        return ans;
    }
}