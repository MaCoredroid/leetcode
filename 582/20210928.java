class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<pid.size();i++){
            if(!map.containsKey(ppid.get(i))){
                map.put(ppid.get(i),new ArrayList<>());
            }
            map.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        q.offer(kill);
        while(!q.isEmpty()){
            int p=q.poll();
            ans.add(p);
            if(map.containsKey(p)){
                for(int next:map.get(p)){
                    q.offer(next);
                }
            }
        }
        return ans;
    }
}