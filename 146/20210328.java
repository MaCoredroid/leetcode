class LRUCache {
    int capacity;
    HashMap<Integer,Node> res;
    Node head;
    Node tail;
    int curr;
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(){

        }
        public Node(int key,int val){
            this.key=key;
            this.value=val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;
        res=new HashMap<>();
        curr=0;
    }
    
    public int get(int key) {
        Node node=res.get(key);
        if(node!=null){
            moveToHead(node);
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(res.get(key)!=null){
            Node tomodify=res.get(key);
            tomodify.value=value;
            moveToHead(tomodify);
        }else{
            Node toAdd=new Node(key,value);
            res.put(key,toAdd);
            addToHead(toAdd);
            curr++;
            if(curr>capacity){
                res.remove(tail.prev.key);
                removeTail();
            }
        }
    }

    private void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void removeTail(){
        removeNode(tail.prev);
    }

    private void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }
    private void addToHead(Node node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */