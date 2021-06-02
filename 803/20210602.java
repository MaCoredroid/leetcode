class Solution {
    public static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int row=grid.length;
        int col=grid[0].length;
        int size=row*col;
        int[][] copy = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        for(int[] hit:hits){
            copy[hit[0]][hit[1]]=0;
        }
        UnionFind uf=new UnionFind(size+1);
        for(int j=0;j<col;j++){
            if(copy[0][j]==1){
                uf.union(j,size);
            }
        }
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                if(copy[i][j]==1){
                    if(copy[i-1][j]==1){
                        uf.union(i*col+j,(i-1)*col+j);
                    }
                    if(j>0&&copy[i][j-1]==1){
                        uf.union(i*col+j-1,i*col+j);
                    }
                }
            }
        }
        int[] res=new int[hits.length];
        for(int i=hits.length-1;i>=0;i--){
            int x=hits[i][0];
            int y=hits[i][1];
            if(grid[x][y]==0){
                continue;
            }
            int origin=uf.getsize();
            if(x==0){
                uf.union(y,size);
            }
            for(int j=0;j<4;j++){
                int newx=x+DIRECTIONS[j][0];
                int newy=y+DIRECTIONS[j][1];
                if(newx<0||newx>=row||newy<0||newy>=col||copy[newx][newy]==0){
                    continue;
                }
                uf.union(x*col+y,newx*col+newy);
            }
            int current=uf.getsize();
            res[i]=Math.max(0,current-origin-1);
            copy[x][y]=1;
        }
        return res;
        
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

    public int find(int a){
        if(a!=parent[a]){
            parent[a]=find(parent[a]);
        }
        return parent[a];
    }

    public void union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA==rootB){
            return;
        }
        parent[rootA]=rootB;
        size[rootB]+=size[rootA];
    }

    public int getsize(){
        int root=find(size.length-1);
        return size[root];
    }
}