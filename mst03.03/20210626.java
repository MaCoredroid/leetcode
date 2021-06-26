class StackOfPlates {
    List<Stack<Integer>> ans;
    int p=0;
    int cap;
    public StackOfPlates(int cap) {
        ans=new ArrayList<>();
        this.cap=cap;
    }
    
    public void push(int val) {
        if (cap <= 0) {
            return;
        }
        if(ans.size()==0||ans.get(ans.size()-1).size()==cap){
            ans.add(new Stack<>());
        }
        ans.get(ans.size()-1).push(val);
    }
    
    public int pop() {
        return popAt(ans.size() - 1);
    }
    
    public int popAt(int index) {
        if (index < 0 || index >= ans.size()) {
            return -1;
        }
        Stack<Integer> stack = ans.get(index);
        int res = stack.pop();
        if (stack.isEmpty()) {
            ans.remove(index);
        }
        return res;
    }

}

/**
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates obj = new StackOfPlates(cap);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAt(index);
 */