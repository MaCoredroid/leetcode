class Node {
    int k;
    int v;
    Node pre;
    Node next;

    Node(int k, int v) {
        this.k = k;
        this.v = v;
    }
}





class LRUCache{
    private int capacity;
    private HashMap<Integer, Node> map=new HashMap<>();
    private Node head;
    private Node tail;
    
    public LRUCache (int capacity) {
        this.capacity=capacity;
        
    }
    public LRUCache()
    {
        
    }
    public int get(int key) {
        Node node=map.get(key);
        if(node!=null)
        {
            moveNodeToTail(node);
            return node.v;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node=map.get(key);
        if(node!=null)
        {
            node.v=value;
            moveNodeToTail(node);
        }
        else
        {
            Node newNode=new Node(key,value);
            if(map.size()==capacity)
            {
                Node temp=removeHead();
                map.remove(temp.k);
            }
            addLast(newNode);
            map.put(key,newNode);
        }
    }

    private void moveNodeToTail(Node node) {
        if(tail==node)
        {
            return;
        }
        if(head==node)
        {
            head=node.next;
            head.pre=null;
        }
        else
        {
            node.pre.next=node.next;
            node.next.pre=node.pre;
        }
        node.pre=tail;
        node.next=null;
        tail.next=node;
        tail=node;
    }

    private void addLast(Node newNode) {
        if(newNode==null)
        {
            return;
        }
        if(head==null)
        {
            head=newNode;
            tail=newNode;
        }
        else{
            tail.next=newNode;
            newNode.pre=tail;
            tail=newNode;
        }
    }
    private Node removeHead() {
        if(head==null)
        {
            return null;
        }
        Node temp=head;
        if(head==tail)
        {
            head=null;
            tail=null;
        }
        else
        {
            head=temp.next;
            head.pre=null;
            temp.next=null;

        }
        return temp;
    }
   
}