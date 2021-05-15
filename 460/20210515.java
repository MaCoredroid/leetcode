class LFUCache {
    Map<Integer,Node> map;
    Map<Integer,LinkedList<Node>> freqmap;
    int minfreq,capacity;
    public LFUCache(int capacity) {
        this.map=new HashMap<>();
        this.freqmap=new HashMap<>();
        this.minfreq=0;
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(capacity==0){
            return -1;
        }
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);
        freqmap.get(node.freq).remove(node);
        if(freqmap.get(node.freq).size()==0){
            freqmap.remove(node.freq);
            if(node.freq==minfreq){
                minfreq++;
            }
        }
        LinkedList<Node> temp=freqmap.getOrDefault(node.freq+1,new LinkedList<Node>());
        node.freq++;
        temp.offerLast(node);
        freqmap.put(node.freq,temp);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        if(!map.containsKey(key)){
            if(map.size()==capacity){
                Node toDelete=freqmap.get(minfreq).pollFirst();
                map.remove(toDelete.key);
                if(freqmap.get(minfreq).size()==0){
                    freqmap.remove(minfreq);
                }
            }
            Node toAdd=new Node(key,value,1);
            map.put(key,toAdd);
            LinkedList<Node> temp=freqmap.getOrDefault(1,new LinkedList<Node>());
            temp.add(toAdd);
            freqmap.put(1,temp);
            minfreq=1;
        }else{
            Node node=map.get(key);
            freqmap.get(node.freq).remove(node);
            if(freqmap.get(node.freq).size()==0){
                freqmap.remove(node.freq);
                if(node.freq==minfreq){
                    minfreq++;
                }
            }
            LinkedList<Node> temp=freqmap.getOrDefault(node.freq+1,new LinkedList<Node>());
            node.freq++;
            node.val=value;
            temp.offerLast(node);
            freqmap.put(node.freq,temp);
        }
    }
}

class Node{
    int key,val,freq;
    public Node(int key,int val,int freq){
        this.key=key;
        this.val=val;
        this.freq=freq;
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */