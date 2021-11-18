class Solution {
    int[][] dirs=new int[][]{{1,0},{1,1},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1){
            return -1;
        }
        if(grid.length==1&&grid[0].length==1){
            return 1;
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->(o1[2]-o2[2]));
        pq.offer(new int[]{0,0,1});
        grid[0][0]=1;
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            for(int i=0;i<8;i++){
                int newX=temp[0]+dirs[i][0];
                int newY=temp[1]+dirs[i][1];
                if(newX>=0&&newX<grid.length&&newY>=0&&newY<grid[0].length&&grid[newX][newY]==0){
                    if(newX==grid.length-1&&newY==grid[0].length-1){
                        return temp[2]+1;
                    }
                    pq.offer(new int[]{newX,newY,temp[2]+1});
                    grid[newX][newY]=1;
                }
            }
        }
        return -1;
        
    }
}