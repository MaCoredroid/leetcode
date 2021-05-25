class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf=new UnionFind(s.length());
        for(List<Integer> pair:pairs){
            uf.union(pair.get(0),pair.get(1));
        }
        char[] ch=s.toCharArray();
        Map<Integer,PriorityQueue<Character>> map=new HashMap<>();
        for(int i=0;i<ch.length;i++){
            int root=uf.find(i);
            if(!map.containsKey(root)){
                map.put(root,new PriorityQueue<Character>());
            }
            map.get(root).offer(ch[i]);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ch.length;i++){
            int root=uf.find(i);
            sb.append(map.get(root).poll());
        }
        return sb.toString();

    }
}

class UnionFind{
    int[] parent;
    int[] rank;
    public UnionFind(int n){
        this.parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        this.rank=new int[n];
    }

    public void union(int a, int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA!=rootB){
            if(rank[rootA]>rank[rootB]){
                parent[rootB]=rootA;                
            }else if(rank[rootA]<rank[rootB]){
                parent[rootA]=rootB;
            }else{
                parent[rootB]=rootA;
                rank[rootA]++;
            }
        }
    }

    public int find(int a){
        if(a!=parent[a]){
            parent[a]=find(parent[a]);
        }
        return parent[a];
    }
}