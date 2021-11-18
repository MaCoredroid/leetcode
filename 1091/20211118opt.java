class Solution {
    int[][] dirs=new int[][]{{1,0},{1,1},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1){
            return -1;
        }
        if(grid.length==1&&grid[0].length==1){
            return 1;
        }
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0});
        grid[0][0]=1;
        int step=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int j=0;j<size;j++){
                
            
                int[] temp=q.poll();
                for(int i=0;i<8;i++){
                    int newX=temp[0]+dirs[i][0];
                    int newY=temp[1]+dirs[i][1];
                    if(newX>=0&&newX<grid.length&&newY>=0&&newY<grid[0].length&&grid[newX][newY]==0){
                        if(newX==grid.length-1&&newY==grid[0].length-1){
                            return step+1;
                        }
                        q.offer(new int[]{newX,newY});
                        grid[newX][newY]=1;
                    }
                }
            }
            step++;
        }
        return -1;
        
    }
}