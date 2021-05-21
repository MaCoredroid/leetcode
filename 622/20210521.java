class MyCircularQueue {
    private int[] queue;
    private int headIndex;
    private int count;
    private int capacity;

    public MyCircularQueue(int k) {
        this.queue=new int[k];
        this.headIndex=0;
        this.count=0;
        this.capacity=k;
    }
    
    public boolean enQueue(int value) {
        if(capacity==count){
            return false;
        }
        queue[(headIndex+count)%capacity]=value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(count==0){
            return false;
        }
        headIndex=(headIndex+1)%capacity;
        count--;
        return true;
    }
    
    public int Front() {
        if(count==0){
            return -1;
        }
        return queue[headIndex];
    }
    
    public int Rear() {
        if(count==0){
            return -1;
        }
        return queue[(headIndex+count-1)%capacity];
    }
    
    public boolean isEmpty() {
        return count==0;
    }
    
    public boolean isFull() {
        return count==capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */