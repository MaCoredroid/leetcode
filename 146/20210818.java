class LRUCache {

    private Node head;
    private Node tail;
    private HashMap<Integer,Node> map;
    private int capacity;
    private int size;
    
    public LRUCache(int capacity) {
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.pre=head;
        this.map=new HashMap<>();
        this.capacity=capacity;
        this.size=0;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node ans=map.get(key);
            moveToHead(ans);
            return ans.value;
        }else{
            return -1;
        }
    }
    
    private void moveToHead(Node ans){
        deleteNode(ans);
        addToHead(ans);
    }
    
    private void addToHead(Node ans){
        Node next=head.next;
        head.next=ans;
        ans.next=next;
        ans.pre=head;
        next.pre=ans;
    }
    
    private void deleteNode(Node ans){
        ans.pre.next=ans.next;
        ans.next.pre=ans.pre;
    }
    
    //TODO deal with nothing to remove
    private Node removeTail(){
        Node toRemove=tail.pre;
        tail.pre=toRemove.pre;
        toRemove.pre.next=tail;
        return toRemove;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node ans=map.get(key);
            ans.value=value;
            moveToHead(ans);
        }else{
            Node toAdd=new Node(key,value);
            addToHead(toAdd);
            map.put(key,toAdd);
            size++;
            if(size>capacity){
                Node toRemove=removeTail();
                map.remove(toRemove.key);
                size--;
            }
        }
    }
    
    
}

class Node{
    Node pre;
    Node next;
    int key;
    int value;
    
    public Node(int key,int value){
        this.pre=null;
        this.next=null;
        this.key=key;
        this.value=value;
    }
}
