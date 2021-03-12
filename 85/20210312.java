class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int[][] left=new int[matrix.length][matrix[0].length];
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0: left[i][j - 1]) + 1;
                }
            }
        }
        int ans=0;
        for(int j=0;j<matrix[0].length;j++){
            int[] templeft=new int[matrix.length];
            int[] tempright=new int[matrix.length];
            Stack<Integer> stack=new Stack<>();
            Arrays.fill(tempright,matrix.length);
            for(int i=0;i<matrix.length;i++){
                while(!stack.isEmpty()&&left[i][j]<=left[stack.peek()][j]){
                    tempright[stack.peek()]=i;
                    stack.pop();
                }
                templeft[i]=stack.isEmpty()?-1:stack.peek();
                stack.push(i);
            }
            for(int i=0;i<matrix.length;i++){
                ans=Math.max(ans,(tempright[i]-templeft[i]-1)*left[i][j]);
            }
        }
        return ans;
    }
}