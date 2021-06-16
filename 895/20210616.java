class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxfreq;
    public FreqStack() {
        freq=new HashMap<>();
        group=new HashMap<>();
        maxfreq=0;
    }
    
    public void push(int val) {
        int f=freq.getOrDefault(val,0)+1;
        freq.put(val,f);
        if(f>maxfreq){
            maxfreq=f;
        }
        if(!group.containsKey(f)){
            group.put(f,new Stack<>());
        }
        group.get(f).push(val);
    }
    
    public int pop() {
        int x=group.get(maxfreq).pop();
        int f=freq.get(x)-1;
        freq.put(x,f);
        if(group.get(maxfreq).size()==0){
            maxfreq--;
        }
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */