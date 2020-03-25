import java.util.HashMap;

class Node {
    int key;
    int val;
    Node pre;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}


class LRUCache {
    private int capacity=0;
    private HashMap<Integer,Node> map=new HashMap<>();
    private Node head=null;
    private Node tail=null;
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public int get(int key) {
        Node ret=map.get(key);
        if(ret!=null)
        {
            movetoTail(ret);
            return ret.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node ret=map.get(key);
        if(ret!=null)
        {
            ret.val=value;
            movetoTail(ret);
        }
        else
        {
            Node newNode= new Node(key,value);
            if(map.size()==capacity)
            {
                Node removed=removeHead();
                map.remove(removed.key);

            }
            addtoTail(newNode);
            map.put(key,newNode);
        }
    }

    private void movetoTail(Node temp)
    {
        if(temp==tail)
        {
            return;
        }
        if(head==temp)
        {
            head=head.next;
            head.pre=null;
        }
        else
        {
            temp.pre.next=temp.next;
            temp.next.pre=temp.pre;
        }
        temp.pre=tail;
        temp.next=null;
        tail.next=temp;
        tail=tail.next;
    }

    private void addtoTail(Node temp)
    {
        if(temp==null)
        {
            return;
        }
        if(head==null)
        {
            head=temp;
            tail=temp;
        }
        else
        {
            tail.next=temp;
            temp.pre=tail;
            tail=tail.next; 
            tail.next=null;
        }
    }

    private Node removeHead()
    {
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
            temp.pre=null;
        }
        return temp;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */