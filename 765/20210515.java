class Solution {
    public int minSwapsCouples(int[] row) {
        UnionFind UF=new UnionFind(row.length/2);
        for(int i=0;i<row.length-1;i+=2){
            UF.Union(row[i]/2,row[i+1]/2);
        }
        return row.length/2-UF.count;
    }
}

class UnionFind{
    int[] parent;
    int count;
    public UnionFind(int n){
        this.parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        count=n;
    }

    public void Union(int i,int j){
        int rooti=find(i);
        int rootj=find(j);
        if(rooti!=rootj){
            parent[rooti]=rootj;
            count--;
        }
    }

    public int find(int i){
        if(i!=parent[i]){
            parent[i]=find(parent[i]);
        }
        return parent[i];
    }
}