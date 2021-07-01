class LRUCache {
    int capacity;
    HashMap<Integer,Node> map;
    Node head;
    Node tail;
    int size;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.size=0;
        this.map=new HashMap<>();
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        head.next=tail;
        tail.pre=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            moveToHead(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).value=value;
            moveToHead(map.get(key));
        }else{
            this.size++;
            Node node=new Node(key,value);
            map.put(key,node);
            addToHead(node);
        }
    }
    
    private void moveToHead(Node node){
        delete(node);
        addToHead(node);
    }
    
    private void addToHead(Node node){
        Node next=head.next;
        head.next=node;
        node.pre=head;
        node.next=next;
        next.pre=node;
        if(this.size>this.capacity){
            removeTail();
        }
    }
    
    private void delete(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
    
    private void removeTail(){
        Node toDelete=tail.pre;
        map.remove(toDelete.key);
        size--;
        delete(toDelete);
    }
}

class Node{
    Node pre;
    Node next;
    int key;
    int value;
    public Node(int key,int value){
        this.key=key;
        this.value=value;
        this.pre=null;
        this.next=null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */