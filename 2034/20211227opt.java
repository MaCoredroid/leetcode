class StockPrice {
    HashMap<Integer,Integer> map;
    int t=-1;
    PriorityQueue<Node> p;
    PriorityQueue<Node> q;
    public StockPrice() {
        this.map=new HashMap<>();
        this.p=new PriorityQueue<>((o1,o2)->(o2.price-o1.price));
        this.q=new PriorityQueue<>((o1,o2)->(o1.price-o2.price));
    }
    
    public void update(int timestamp, int price) {
        Node n=new Node(timestamp,price);
        if(t==-1||timestamp>t){
            t=timestamp;
        }
        map.put(timestamp,price);
        p.offer(n);
        q.offer(n);
    }
    
    public int current() {
        return map.get(t);
    }
    
    public int maximum() {
        while(!p.isEmpty()){
            Node res=p.peek();
            if(map.get(res.timestamp)==res.price){
                return res.price;
            }else{
                p.poll();
            }
        }
        return -1;
    }
    
    public int minimum() {
        while(!q.isEmpty()){
            Node res=q.peek();
            if(map.get(res.timestamp)==res.price){
                return res.price;
            }else{
                q.poll();
            }
        }
        return -1;
    }
}

class Node{
    int timestamp;
    int price;
    public Node(int timestamp,int price){
        this.timestamp=timestamp;
        this.price=price;
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */