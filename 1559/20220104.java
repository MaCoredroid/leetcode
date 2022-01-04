class Solution {
    int[][] dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public boolean containsCycle(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>='a'){
                    char val=grid[i][j];
                    Queue<Integer> q=new LinkedList<>();
                    q.offer(i*n+j);
                    while(!q.isEmpty()){   
                        Integer temp=q.poll();
                        int row=temp/n;
                        int col=temp%n;
                        if(grid[row][col]<'a') return true;
                        grid[row][col]-=26;
                        for(int k=0;k<4;k++){
                            int newX=row+dirs[k][0];
                            int newY=col+dirs[k][1];
                            if(newX>=0&&newX<m&&newY>=0&&newY<n&&grid[newX][newY]==val){
                                q.offer(newX*n+newY);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    
}