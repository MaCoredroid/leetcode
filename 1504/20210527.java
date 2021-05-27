class Solution {
    public int numSubmat(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] row=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(j==0){
                    row[i][j]=mat[i][j];
                }else if(mat[i][j]==0){
                    row[i][j]=0;
                }else{
                    row[i][j]=row[i][j-1]+1;
                }
            }
        }
        int ans=0;
        for(int i=0;i<m;i++){
            int sum=0;
            Stack<int[]> stack=new Stack<>();
            for(int j=0;j<n;j++){
                int height=1;
                while(!stack.isEmpty()&&stack.peek()[0]>row[j][i]){
                    sum-=stack.peek()[1]*(stack.peek()[0]-row[j][i]);
                    height+=stack.peek()[1];
                    stack.pop();
                }
                sum+=row[j][i];
                ans+=sum;
                stack.push(new int[]{row[j][i],height});
            }
        }
        return ans;
    }
}