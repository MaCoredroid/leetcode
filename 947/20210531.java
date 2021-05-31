class Solution {
    public int removeStones(int[][] stones) {
        UnionFind uf=new UnionFind();
        for(int i=0;i<stones.length;i++){
            uf.union(stones[i][0]+10001,stones[i][1]);
        }
        return stones.length-uf.count;
    }
}

class UnionFind{
    Map<Integer,Integer> parent;
    int count;
    public UnionFind(){
        parent=new HashMap<>();
        count=0;
    }

    public int find(int x){
        if(!parent.containsKey(x)){
            count++;
            parent.put(x,x);
        }else{
            if(x!=parent.get(x)){
                parent.put(x,find(parent.get(x)));
            }
        }
        return parent.get(x);
        
    }

    public void union(int x,int y){
        int rootX=find(x);
        int rootY=find(y);
        if(rootX!=rootY){
            count--;
            parent.put(rootX,rootY);
        }
    }
}