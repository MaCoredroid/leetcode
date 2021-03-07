class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid,int i,int j){
        Queue<Integer> set= new LinkedList<>();
        set.add(i*grid[0].length+j);
        while(!set.isEmpty()){
            int ret=set.remove();
            int p=ret/grid[0].length;
            int q=ret%grid[0].length;
            if(p-1>=0&&grid[p-1][q]=='1'){
                set.add((p-1)*grid[0].length+q);
                grid[p-1][q]='0';
            }
            if(p+1<grid.length&&grid[p+1][q]=='1'){
                set.add((p+1)*grid[0].length+q);
                grid[p+1][q]='0';
            }
            if(q+1<grid[0].length&&grid[p][q+1]=='1'){
                set.add(p*grid[0].length+q+1);
                grid[p][q+1]='0';
            }
            if(q-1>=0&&grid[p][q-1]=='1'){
                set.add(p*grid[0].length+q-1);
                grid[p][q-1]='0';
            }
        }
        
    }
}