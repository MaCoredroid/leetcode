class MyCircularDeque {
    Node head;
    Node tail;
    int size=0;
    int limit=0;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.limit=k;
        head=new Node(-1);
        tail=new Node(-1);
        head.next=tail;
        tail.pre=head;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(size==limit){
            return false;
        }
        Node next=head.next;
        Node toAdd=new Node(value);
        head.next=toAdd;
        toAdd.next=next;
        next.pre=toAdd;
        toAdd.pre=head;
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size==limit){
            return false;
        }
        Node pre=tail.pre;
        Node toAdd=new Node(value);
        pre.next=toAdd;
        toAdd.next=tail;
        toAdd.pre=pre;
        tail.pre=toAdd;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size==0){
            return false;
        }
        size--;
        Node toDelete=head.next;
        Node next=toDelete.next;
        head.next=next;
        next.pre=head;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size==0){
            return false;
        }
        size--;
        Node toDelete=tail.pre;
        Node pre=toDelete.pre;
        pre.next=tail;
        tail.pre=pre;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(size==0){
            return -1;
        }
        return head.next.val;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(size==0){
            return -1;
        }
        return tail.pre.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size==limit;
    }
}

class Node{
    Node pre=null;
    Node next=null;
    int val=0;
    public Node(int val){
        this.val=val;
    }
}
/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */