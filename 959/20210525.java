class Solution {
    public int regionsBySlashes(String[] grid) {
        int n=grid.length;
        UnionFind uf=new UnionFind(4*n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int index=4*(i*n+j);
                char c=grid[i].charAt(j);
                if(c==' '){
                    uf.union(index,index+1);
                    uf.union(index+1,index+2);
                    uf.union(index+2,index+3);
                }else if(c=='/'){
                    uf.union(index,index+1);
                    uf.union(index+2,index+3);
                }else{
                    uf.union(index,index+3);
                    uf.union(index+1,index+2);
                }
                if(j+1<n){
                    uf.union(index+3,4*(i*n+j+1)+1);
                }
                if(i+1<n){
                    uf.union(index+2,4*(i*n+j+n));
                }
            }
        }
        return uf.count;
    }
}

class UnionFind{
    int[] parent;
    int[] rank;
    int count=0;
    public UnionFind(int n){
        parent=new int[n];
        rank=new int[n];
        count=n;
        for(int i=0;i<n;i++){
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
        if(rootA!=rootB){
            count--;
            if(rank[rootA]==rank[rootB]){
                rank[rootA]++;
                parent[rootB]=rootA;
            }else if(rank[rootA]>rank[rootB]){
                parent[rootB]=rootA;
            }else{
                parent[rootA]=rootB;
            }
        }
    }
}