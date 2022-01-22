class Solution {
    public int swimInWater(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->(o1[2]-o2[2]));
        pq.offer(new int[]{0,0,grid[0][0]});
        grid[0][0]=-1;
        int max=0;
        while(pq.size()>0){
            int[] temp=pq.poll();
            max=Math.max(temp[2],max);
            for(int k=0;k<4;k++){
                int newX=temp[0]+dirs[k][0];
                int newY=temp[1]+dirs[k][1];
                if(newX<0||newX>=m||newY<0||newY>=n){
                    continue;
                }
                if(newX==m-1&&newY==n-1) return Math.max(max,grid[m-1][n-1]);
                if(grid[newX][newY]!=-1){
                    pq.offer(new int[]{newX,newY,grid[newX][newY]});
                    grid[newX][newY]=-1;
                }
            }
            
        }
        return max;
    }
}