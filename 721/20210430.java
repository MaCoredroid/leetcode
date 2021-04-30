class Solution {
    class UnionFind{
        int[] parents;
        int[] rank;
        public UnionFind(int n){
            parents=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parents[i]=i;
            }
        }

        public void union(int i,int j){
            int root1=find(i);
            int root2=find(j);
            if(rank[root1]>rank[root2]){
                parents[root2]=root1;
            }else if(rank[root1]<rank[root2]){
                parents[root1]=root2;
            }else{
                parents[root2]=root1;
                rank[root1]++;
            }          
        }

        public int find(int i){
            if(parents[i]!=i){
                parents[i]=find(parents[i]);
            }
            return parents[i];
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf=new UnionFind(accounts.size());
        HashMap<String,Integer> map=new HashMap<>();
        for(int j=0;j<accounts.size();j++){
            List<String> account=accounts.get(j);
            for(int i=1;i<account.size();i++){
                if(map.containsKey(account.get(i))){
                    uf.union(map.get(account.get(i)),j);
                }
            }
            for(int i=1;i<account.size();i++){
                map.put(account.get(i),j);
            }
            
        }
        HashMap<Integer,List<String>> res=new HashMap<>();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(!res.containsKey(uf.find(entry.getValue()))){
                res.put(uf.find(entry.getValue()),new ArrayList<>());
            }
            res.get(uf.find(entry.getValue())).add(entry.getKey());
        }
        List<List<String>>ret=new ArrayList<>();
        for(Map.Entry<Integer,List<String>> entry:res.entrySet()){
            List<String> value=entry.getValue();
            Collections.sort(value);
            value.add(0,accounts.get(entry.getKey()).get(0));
            ret.add(value);
        }
        return ret;


    }
}