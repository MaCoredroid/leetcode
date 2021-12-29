class TimeMap {
    HashMap<String,List<Node>> map;
    public TimeMap() {
        this.map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key,new ArrayList<>());
        List<Node> list=map.get(key);
        list.add(new Node(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Node> list=map.get(key);
        int l=0,r=list.size()-1;
        while(l<=r){
            int mid=l+((r-l)>>1);
            if(list.get(mid).timestamp==timestamp){
                return list.get(mid).value;
            }
            if(list.get(mid).timestamp<timestamp){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return l-1<0?"":list.get(l-1).value;
    }
}

class Node{
    String value;
    int timestamp;
    public Node(String value,int timestamp){
        this.value=value;
        this.timestamp=timestamp;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */