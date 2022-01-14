class Solution {
    int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        
        int r=grid.length,c=grid[0].length;
        int size=r*c;
        int[][] copy = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        UnionFind uf=new UnionFind(size+1);
        for(int[] h:hits){
            grid[h[0]][h[1]]=0;
        }
        for(int j=0;j<c;j++){
            if(grid[0][j]==1){
                uf.union(j,size);
            }
        }
        for(int i=1;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    if(grid[i-1][j]==1) uf.union(i*c+j,(i-1)*c+j);
                    if(j>0&&grid[i][j-1]==1) uf.union(i*c+j,i*c+j-1);
                }
            }
        }
        int[] ans=new int[hits.length];
        for(int i=hits.length-1;i>=0;i--){
            int x=hits[i][0];
            int y=hits[i][1];
            if(copy[x][y]==0) continue;
            int origin=uf.getSize();
            if(x==0){
                uf.union(y,size);
            }
            for(int j=0;j<4;j++){
                int newx=x+dirs[j][0];
                int newy=y+dirs[j][1];
                if(newx<0||newx>=r||newy<0||newy>=c||grid[newx][newy]==0){
                    continue;
                }
                uf.union(x*c+y,newx*c+newy);
            }
            int current=uf.getSize();
            ans[i]=Math.max(0,current-origin-1);
            grid[x][y]=1;
        }
        return ans;
    }
}

class UnionFind{
    int[] parent;
    int[] size;
    
    public UnionFind(int n){
        this.parent=new int[n];
        this.size=new int[n];
        Arrays.fill(size,1);
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
    }
    public void union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA==rootB){
            return;
        }
        if(size[rootA]<size[rootB]){
            parent[rootA]=rootB;
            size[rootB]+=size[rootA];
        }else{
            parent[rootB]=rootA;
            size[rootA]+=size[rootB];
        }
        
    }
    
    public int find(int a){
        if(parent[a]!=a){
            parent[a]=find(parent[a]);
        } 
        return parent[a];
    }
    
    public int getSize(){
        int root=find(size.length-1);
        return size[root];
    }
}