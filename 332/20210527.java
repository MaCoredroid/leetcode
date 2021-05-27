class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    List<String> itinerary = new LinkedList<String>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> way:tickets){
            if(!map.containsKey(way.get(0))){
                map.put(way.get(0),new PriorityQueue<String>());
            }
            map.get(way.get(0)).add(way.get(1));
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    private void dfs(String start){
        while(map.containsKey(start)&&map.get(start).size()>0){
            String end=map.get(start).poll();
            dfs(end);
        }
        itinerary.add(start);
    }
}