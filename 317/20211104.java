class Solution {
    public int shortestDistance(int[][] grid) {
        int[][] dirs=new int[][]{{0,1},{-1,0},{1,0},{0,-1}};
        int m=grid.length;
        int n=grid[0].length;
        int[][] total=new int[m][n];
        int emptyValue=0;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    ans=Integer.MAX_VALUE;
                    Queue<int[]> q=new LinkedList<>();
                    q.offer(new int[]{i,j});
                    int steps=0;
                    while(!q.isEmpty()){
                        int size=q.size();
                        steps++;
                        for(int p=0;p<size;p++){
                            int[] temp=q.poll();
                            for(int[] dir:dirs){
                                int newX=temp[0]+dir[0];
                                int newY=temp[1]+dir[1];
                                if(newX>=0&&newX<m&&newY>=0&&newY<n&&grid[newX][newY]==emptyValue){
                                    grid[newX][newY]--;
                                    total[newX][newY]+=steps;
                                    q.offer(new int[]{newX,newY});
                                    ans=Math.min(ans,total[newX][newY]);
                                }
                            }
                        }
                    }
                    emptyValue--;
                }
            }
        }
        
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}