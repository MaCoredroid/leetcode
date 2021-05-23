class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        UnionFind uf=new UnionFind(n);
        for(int[] connection:connections){
            uf.union(connection[0],connection[1]);
        }
        return uf.count-1;

    }

    
}

class UnionFind{
    int[] parent;
    int[] weight;
    int count;
    public UnionFind(int n){
        parent=new int[n];
        weight=new int[n];
        this.count=n;
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
    }

    public void union(int i,int j){
        int parentI=find(i);
        int parentJ=find(j);
        if(parentI!=parentJ){
            count--;
            if(weight[parentI]>weight[parentJ]){
                parent[parentJ]=parentI;
            }else if(weight[parentI]==weight[parentJ]){
                parent[parentJ]=parentI;
                weight[parentI]++;
            }else{
                parent[parentI]=parentJ;
            }
        }
    }

    public int find(int i){
        if(parent[i]!=i){
            parent[i]=find(parent[i]);
        }
        return parent[i];
    }
}