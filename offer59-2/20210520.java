class MaxQueue {
    Queue<Integer> q;
    Deque<Integer> p;
    public MaxQueue() {
        q=new LinkedList<>();
        p=new LinkedList<>();
    }
    
    public int max_value() {
        if(q.isEmpty()){
            return -1;
        }
        return p.peekFirst();
    }
    
    public void push_back(int value) {
        while(!p.isEmpty()&&p.peekLast()<value){
            p.pollLast();
        }
        p.offer(value);
        q.offer(value);
    }
    
    public int pop_front() {
        if(q.isEmpty()){
            return -1;
        }
        int ans=q.poll();
        if(ans==p.peekFirst()){
            p.pollFirst();
        }
        return ans;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */