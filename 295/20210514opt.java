class MedianFinder {
    PriorityQueue<Integer> maxHeap=new PriorityQueue<>((x,y)->y-x);
    PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(((maxHeap.size()+minHeap.size())&1)!=0){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(((maxHeap.size()+minHeap.size())&1)!=0){
            return maxHeap.peek();
        }else{
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */