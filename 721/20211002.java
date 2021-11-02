class Solution {
    HashSet<String> visited=new HashSet<>();
    HashMap<String,List<String>> map=new HashMap<>();
    
    public void DFS(List<String> mergeAccounts, String first){
        visited.add(first);
        mergeAccounts.add(first);
        for(String next:map.get(first)){
            if(!visited.contains(next)){
                DFS(mergeAccounts,next);
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for(List<String> account:accounts){
            String first=account.get(1);
            if(!map.containsKey(first)){
                map.put(first,new ArrayList<>());
            }
            for(int i=2;i<account.size();i++){
                map.get(first).add(account.get(i));
                if(!map.containsKey(account.get(i))){
                    map.put(account.get(i),new ArrayList<>());
                }
                map.get(account.get(i)).add(first);
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for(List<String> account:accounts){
            String name=account.get(0);
            String first=account.get(1);
            if(!visited.contains(first)){
                List<String> mergedAccounts=new ArrayList<>();
                mergedAccounts.add(name);
                DFS(mergedAccounts,first);
                Collections.sort(mergedAccounts.subList(1,mergedAccounts.size()));
                ans.add(mergedAccounts);
            }
        }
        return ans;
    }
}
