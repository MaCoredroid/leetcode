class MinStack {

    private Stack<Integer> res;
    private Stack<Integer> minstack;
    /** initialize your data structure here. */
    public MinStack() {
        this.res=new Stack<>();
        this.minstack=new Stack<>();
    }
    
    public void push(int x) {
        res.push(x);
        if(minstack.size()==0)
        {
            minstack.push(x);
            return;
        }
        if(x<minstack.peek())
        {
            minstack.push(x);
        }
        else
        {
            minstack.push(minstack.peek());
        }
    }
    
    public void pop() {
        if(res.size()>0)
        {
            res.pop();
            minstack.pop();
        }
    }
    
    public int top() {
        if(res.size()>0)
        {
            return res.peek();
        }
        return -1;
    }
    
    public int min() {
        if(minstack.size()>0)
        {
            return minstack.peek();
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */