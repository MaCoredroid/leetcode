class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> queue=new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> entry1,Map.Entry<String,Integer> entry2){
                return entry1.getValue()==entry2.getValue()?entry2.getKey().compareTo(entry1.getKey()):entry1.getValue()-entry2.getValue();
            }
        });
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            queue.offer(entry);
            if(queue.size()>k){
                queue.poll();
            }
        }
        List<String> ans=new ArrayList<>();
        while(!queue.isEmpty()){
            ans.add(0,queue.poll().getKey());
        }
        return ans;

    }
}