class MyLinkedList {
    Node dummy;
    int size=0;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        dummy=new Node(-1);
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0||index>=size){
            return -1;
        }
        Node curr=dummy;
        for(int i=0;i<=index;i++){
            curr=curr.next;
        }
        return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) return;

        if(index<0){
            index=0;
        }
        Node prev=dummy;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        Node toAdd=new Node(val);
        toAdd.next=prev.next;
        prev.next=toAdd;
        size++;

    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size || index<0){
            return;
        } 
    
        Node prev=dummy;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        prev.next=prev.next.next;
        size--;
    }
}

class Node{
    int val;
    Node next;
    public Node(int val){
        this.val=val;
        next=null;
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