class MyLinkedList {
    Node head;
    Node tail;
    int size=0;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head=new Node(-1);
        tail=new Node(-1);
        head.next=tail;
        tail.prev=head;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0||index>=size){
            return -1;
        }
        Node curr=head;
        if(index+1<size-index){
            for(int i=0;i<=index;i++){
                curr=curr.next;
            }
        }else{
            curr=tail;
            for(int i=0;i<size-index;i++){
                curr=curr.prev;
            }
        }
        return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node toAdd=new Node(val);
        Node pred=head;
        Node succ=head.next;
        pred.next=toAdd;
        toAdd.prev=pred;
        toAdd.next=succ;
        succ.prev=toAdd;
        size++;
        
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node toAdd=new Node(val);
        Node pred=tail.prev;
        Node succ=tail;
        pred.next=toAdd;
        toAdd.prev=pred;
        toAdd.next=succ;
        succ.prev=toAdd;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index>size){
            return;
        }
        if(index<0){
            index=0;
        }
        Node pred,succ;
        if(index<size-index){
            pred=head;
            for(int i=0;i<index;i++){
                pred=pred.next;
            }
            succ=pred.next;
        }else{
            succ=tail;
            for(int i=0;i<size-index;i++){
                succ=succ.prev;
            }
            pred=succ.prev;
        }
        size++;
        Node toAdd=new Node(val);
        pred.next=toAdd;
        toAdd.prev=pred;
        toAdd.next=succ;
        succ.prev=toAdd;

    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<0||index>=size){
            return;
        }
        Node curr=head;
        if(index+1<size-index){
            for(int i=0;i<=index;i++){
                curr=curr.next;
            }
        }else{
            curr=tail;
            for(int i=0;i<size-index;i++){
                curr=curr.prev;
            }
        }
        size--;
        Node pred=curr.prev;
        Node succ=curr.next;
        pred.next=succ;
        succ.prev=pred;

    }
}

class Node{
    int val;
    Node next;
    Node prev;
    public Node(int val){
        this.val=val;
        next=null;
        prev=null;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */