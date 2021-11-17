class MovingAverage {
    double size;
    Queue<Integer> q;
    double ans;
    public MovingAverage(int size) {
        this.size=size;
        this.q=new LinkedList<>();
        this.ans=0.0;
    }
    
    public double next(int val) {
        if(q.size()==size){
            ans-=q.poll()/size;
            ans+=val/size;
        }else{
            ans=(ans*q.size()+val)/(q.size()+1);
            
        }
        q.offer(val);
        return ans;
        
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */