class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf=new UnionFind(n);
        for(int[] edge:edges){
            uf.union(edge[0],edge[1]);
        }
        return uf.cnt;
    }
}

class UnionFind{
    int[] parents;
    int[] weights;
    int cnt;
    public UnionFind(int n){
        parents=new int[n];
        for(int i=0;i<n;i++){
            parents[i]=i;
        }
        cnt=n;
        weights=new int[n];
    }

    public void union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA!=rootB){
            if(weights[rootA]==weights[rootB]){
                weights[rootA]++;
                parents[rootB]=rootA;
            }else if(weights[rootA]>weights[rootB]){
                parents[rootB]=rootA;
            }else{
                parents[rootA]=rootB;
            }
            cnt--;
        }
    }

    public int find(int a){
        if(a!=parents[a]){
            parents[a]=find(parents[a]);
        }
        return parents[a];
    }
}