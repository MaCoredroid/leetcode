class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf=new UnionFind(edges.length+1);
        for(int[] edge:edges){
            if(!uf.union(edge[0],edge[1])){
                return edge;
            }
        }
        return new int[]{-1,-1};
    }
}

class UnionFind{
    int[] parent;
    int count;
    public UnionFind(int n){
        parent=new int[n];
        count=n;
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
    }

    public boolean union(int i,int j){
        int parentI=find(i);
        int parentJ=find(j);
        if(parentI!=parentJ){
            parent[parentI]=parentJ;
            return true;
        }else{
            return false;
        }
    }

    public int find(int i){
        if(i!=parent[i]){
            parent[i]=find(parent[i]);
        }
        return parent[i];
    }
}