class MyHashSet {
    private static final int BASE = 769;
    private LinkedList[] data;
    /** Initialize your data structure here. */
    public MyHashSet() {
        data=new LinkedList[BASE];
        for(int i=0;i<BASE;i++){
            data[i]=new LinkedList<>();
        }
    }
    
    public void add(int key) {
        int index=key%BASE;
        Iterator<Integer> it=data[index].iterator();
        while(it.hasNext()){
            Integer next=it.next();
            if(next==key){
                return;
            }
        }
        data[index].offerLast(key);
    }
    
    public void remove(int key) {
        int index=key%BASE;
        Iterator<Integer> it=data[index].iterator();
        while(it.hasNext()){
            Integer next=it.next();
            if(next==key){
                data[index].remove(next);
                return;
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index=key%BASE;
        Iterator<Integer> it=data[index].iterator();
        while(it.hasNext()){
            Integer next=it.next();
            if(next==key){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */