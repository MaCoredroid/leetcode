class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n=edges.length;
        UnionFind uf=new UnionFind(n+1);
        int[] parent=new int[n+1];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        int cycle=-1;
        int duplication=-1;
        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            if(parent[to]!=to){
                duplication=i;
            }else{
                parent[to]=from;
                if(uf.find(to)==uf.find(from)){
                    cycle=i;
                }else{
                    uf.union(from,to);
                }
            }
        }
        if(duplication<0){
            return edges[cycle];
        }else{
            if(cycle>=0){
                return new int[]{parent[edges[duplication][1]],edges[duplication][1]};
            }else{
                return edges[duplication];
            }
        }
    }
}

class UnionFind{
    int parent[];
    public UnionFind(int n){
        this.parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }

    public void union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA!=rootB){
            parent[rootA]=rootB;
        }
    }

    public int find(int a){
        if(a!=parent[a]){
            parent[a]=find(parent[a]);
        }
        return parent[a];
    }
}