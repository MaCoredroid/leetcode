class MyHashMap {
    private static final int BASE = 769;
    private LinkedList[] data;
    /** Initialize your data structure here. */
    public MyHashMap() {
        data=new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            data[i] = new LinkedList<int[]>();
        }

    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h=hash(key);
        Iterator<int[]> iterator = data[h].iterator();
        while(iterator.hasNext()){
            int[] element=iterator.next();
            if(element[0]==key){
                element[1]=value;
                return;
            }
        }
        data[h].offerLast(new int[]{key,value});
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h=hash(key);
        Iterator<int[]> iterator = data[h].iterator();
        while(iterator.hasNext()){
            int[] element=iterator.next();
            if(element[0]==key){
                return element[1];
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h=hash(key);
        Iterator<int[]> iterator = data[h].iterator();
        while(iterator.hasNext()){
            int[] element=iterator.next();
            if(element[0]==key){
                data[h].remove(element);
                return;
            }
        }
    }

    private static int hash(int key){
        return key%BASE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */