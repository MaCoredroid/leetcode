class StockSpanner {
    Stack<Integer> nums,weights;
    public StockSpanner() {
        nums=new Stack();
        weights=new Stack();
    }
    
    public int next(int price) {
        int weight=1;
        while(!nums.isEmpty()&&nums.peek()<=price){
            nums.pop();
            weight+=weights.pop();
        }
        weights.push(weight);
        nums.push(price);
        return weight;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */