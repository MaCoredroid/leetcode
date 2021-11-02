class Solution {
    HashMap<String,Integer> emailToIndex=new HashMap<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf=new UnionFind(accounts.size());
        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                if(emailToIndex.containsKey(accounts.get(i).get(j))){
                    uf.union(i,emailToIndex.get(accounts.get(i).get(j)));
                }else{
                    emailToIndex.put(accounts.get(i).get(j),i);
                }
            }
        }
        HashMap<Integer,Set<String>> map=new HashMap<>();
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<accounts.size();i++){
            int parent=uf.find(i);
            if(!map.containsKey(parent)){
                map.put(parent,new HashSet<>());
            }
            map.get(parent).addAll(accounts.get(i).subList(1,accounts.get(i).size()));
        }
        for(Map.Entry<Integer,Set<String>> e:map.entrySet()){
            List<String> list=new ArrayList<>(e.getValue());
            Collections.sort(list);
            list.add(0,accounts.get(e.getKey()).get(0));
            ans.add(list);
        }
        return ans;
        
    }
}

class UnionFind{
    int[] parent;
    int[] weight;
    int size;
    public UnionFind(int n){
        this.size=n;
        this.parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        this.weight=new int[n];
    }
    
    public void union(int a,int b){
        int parentA=find(a);
        int parentB=find(b);
        if(parentA!=parentB){
            if(weight[parentA]==weight[parentB]){
                parent[parentA]=parentB;
                weight[parentB]++;
            }else if(weight[parentA]>weight[parentB]){
                parent[parentB]=parentA;
            }else{
                parent[parentA]=parentB;
            }
            size--;
        }
    }
    
    public int find(int a){
        if(parent[a]!=a){
            parent[a]=find(parent[a]);
        }
        return parent[a];
    }
}
