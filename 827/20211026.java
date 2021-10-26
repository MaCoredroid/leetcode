class Solution {
    int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        UnionFind uf=new UnionFind(n*n);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==1){
                    merge(grid,i,j,grid.length,uf);
                }else{
                    uf.weight[i*n+j]=0;
                }
            }
        }
        int ret=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==0){
                    ret=Math.max(mergeIsland(grid,i,j,grid.length,uf),ret);
                }else{
                    ret=Math.max(ret,uf.weight[uf.find(i*n+j)]);
                }
            }
        }
        return ret;
    }
    
    private void merge(int[][] grid,int i,int j,int n,UnionFind uf){
        for(int p=0;p<2;p++){
            int newX=i+dirs[p][0];
            int newY=j+dirs[p][1];
            if(newX>=0&&newX<n&&newY>=0&&newY<n&&grid[newX][newY]==1){
                uf.union(i*n+j,newX*n+newY);
            }
        }
    }
    
    private int mergeIsland(int[][] grid,int i,int j,int n,UnionFind uf){
        Set<Integer> ans=new HashSet<>();
        int ret=1;
        for(int p=0;p<4;p++){
            int newX=i+dirs[p][0];
            int newY=j+dirs[p][1];
            if(newX>=0&&newX<n&&newY>=0&&newY<n&&grid[newX][newY]==1&&!ans.contains(uf.find(newX*n+newY))){
                ret+=uf.weight[uf.find(newX*n+newY)];
                ans.add(uf.find(newX*n+newY));
            }
        }
        
        return ret;
        
        
    }
}

class UnionFind{
    int[] parent;
    int size;
    int[] weight;
    public UnionFind(int n){
        this.parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        this.size=n;
        this.weight=new int[n];
        Arrays.fill(weight,1);
    }
    
    public int find(int a){
        if(parent[a]!=a){
            parent[a]=find(parent[a]);
        }
        return parent[a];
    }
    
    public void union(int a,int b){
        int parentA=find(a);
        int parentB=find(b);
        if(parentA!=parentB){
            if(weight[parentA]==weight[parentB]){
                parent[parentA]=parentB;
                weight[parentB]*=2;
            }else if(weight[parentA]>weight[parentB]){
                parent[parentB]=parentA;
                weight[parentA]+=weight[parentB];
            }else{
                parent[parentA]=parentB;
                weight[parentB]+=weight[parentA];
            }
            size--;
        }
    }
    
    public int getMergeResult(int a, int b){
        if(find(a)==find(b)){
            return 0;
        }
        return weight[find(a)]+weight[find(b)];
    }
}