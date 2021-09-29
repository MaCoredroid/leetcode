class LRUCache {
    int capacity;
    int size;
    Node head;
    Node tail;
    HashMap<Integer,Node> map;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        this.size=0;
        this.map=new HashMap<>();
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        Node node=map.get(key);
        if(node==null){
            return -1;
        }else{
            moveToHead(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        Node node=map.get(key);
        if(node==null){
            size++;
            Node toAdd=new Node(key,value);
            map.put(key,toAdd);
            addToHead(toAdd);
            if(size>capacity){
                removeTail();
                size--;
            }
        }else{
            node.val=value;
            moveToHead(node);
        }
    }
    
    public void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }
    
    public void removeTail(){
        Node toDelete=tail.prev;
        map.remove(toDelete.key);
        removeNode(toDelete);
    }
    
    public void addToHead(Node node){
        head.next.prev=node;
        node.next=head.next;
        head.next=node;
        node.prev=head;
    }
    
    
    public void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
}

class Node{
    Node prev;
    Node next;
    int val;
    int key;
    public Node(int key,int val){
        this.prev=null;
        this.next=null;
        this.key=key;
        this.val=val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */