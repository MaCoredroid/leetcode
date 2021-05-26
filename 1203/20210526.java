class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for(int i=0;i<group.length;i++){
            if(group[i]==-1){
                group[i]=m++;
            }
        }
        List<Integer>[] groups=new ArrayList[m];
        List<Integer>[] items=new ArrayList[n];
        for(int i=0;i<m;i++){
            groups[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            items[i]=new ArrayList<>();
        }
        int[] groupsIndegree = new int[m];
        int[] itemsIndegree = new int[n];
        for(int i=0;i<group.length;i++){
            int currentGroup=group[i];
            for(Integer beforeItem:beforeItems.get(i)){
                int beforeGroup=group[beforeItem];
                if(beforeGroup!=currentGroup){
                    groups[beforeGroup].add(currentGroup);
                    groupsIndegree[currentGroup]++;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(Integer beforeItem:beforeItems.get(i)){
                items[beforeItem].add(i);
                itemsIndegree[i]++;
            }
        }
        List<Integer> groupsList = sort(groups, groupsIndegree, m);
        if (groupsList.size() == 0) {
            return new int[0];
        }
        List<Integer> itemsList = sort(items, itemsIndegree, n);
        if (itemsList.size() == 0) {
            return new int[0];
        }
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(Integer item:itemsList){
            if(!map.containsKey(group[item])){
                map.put(group[item],new ArrayList<>());
            }
            map.get(group[item]).add(item);
        }
        int pointer=0;
        int[] ans=new int[n];
        for(Integer temp:groupsList){
            List<Integer> res=map.getOrDefault(temp,new ArrayList<>());
            for(Integer item:res){
                ans[pointer++]=item;
            }
        }
        return ans;
    }

    private List<Integer> sort(List<Integer>[] adj, int[] inDegree, int n){
        List<Integer> res=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            Integer temp=queue.poll();
            res.add(temp);
            for(Integer next:adj[temp]){
                inDegree[next]--;
                if(inDegree[next]==0){
                    queue.offer(next);
                }
            }
        }
        return res.size()==n?res:new ArrayList<>();
    }
}