class CQueue {
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();
    public CQueue() {

    }
    
    public void appendTail(int value) {
        s1.add(value);
    }
    
    public int deleteHead() {
        if(s2.isEmpty())
        {
            if(s1.isEmpty())
            {
                return -1;
            }
            while(s1.size()>0)
            {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
        else
        {
            return s2.pop();
        }
        
    }
}
