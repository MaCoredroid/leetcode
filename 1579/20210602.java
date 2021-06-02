class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind uf1=new UnionFind(n);
        UnionFind uf2=new UnionFind(n);
        int cnt=0;
        for(int[] edge:edges){
            edge[1]--;
            edge[2]--;
            if(edge[0]==3){
                if(!uf1.union(edge[1],edge[2])){
                    cnt++;
                }else{
                    uf2.union(edge[1],edge[2]);
                }
            }
        }
        for(int[] edge:edges){
            if(edge[0]==1){
                if(!uf1.union(edge[1],edge[2])){
                    cnt++;
                }
            }else if(edge[0]==2){
                if(!uf2.union(edge[1],edge[2])){
                    cnt++;
                }
            }
        }
        if(uf1.setcount!=1||uf2.setcount!=1){
            return -1;
        }
        return cnt;

        
        
    }
}

class UnionFind{
    int[] parent;
    int[] weight;
    int size;
    int setcount;
    public UnionFind(int n){
        this.parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        this.weight=new int[n];
        this.size=n;
        this.setcount=n;
    }

    public boolean union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA==rootB){
            return false;
        }
        if(weight[rootA]>weight[rootB]){
            parent[rootB]=rootA;
        }else if(weight[rootB]>weight[rootA]){
            parent[rootA]=rootB;
        }else{
            parent[rootB]=rootA;
            weight[rootA]++;
        }
        setcount--;
        return true;
    }

    public int find(int a){
        if(a!=parent[a]){
            parent[a]=find(parent[a]);
        }
        return parent[a];
    }
}