class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] updateMatrix(int[][] matrix) {
        int[][] ret=new int[matrix.length][matrix[0].length];
        boolean[][] visited=new boolean[matrix.length][matrix[0].length];
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    ret[i][j]=0;
                    visited[i][j]=true;
                    queue.offer(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] res=queue.poll();
            for(int i=0;i<4;i++){
                int row=res[0]+dirs[i][0];
                int col=res[1]+dirs[i][1];
                if(row>=0&&row<matrix.length&&col>=0&&col<matrix[0].length&&!visited[row][col]){
                    ret[row][col]=ret[res[0]][res[1]]+1;
                    queue.offer(new int[]{row,col});
                    visited[row][col]=true;
                }       
            }
        }
        return ret;
    }
}