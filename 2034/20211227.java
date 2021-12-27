class StockPrice {
    HashMap<Integer,Node> map;
    Node t;
    PriorityQueue<Node> p;
    PriorityQueue<Node> q;
    public StockPrice() {
        this.map=new HashMap<>();
        this.t=null;
        this.p=new PriorityQueue<>((o1,o2)->(o2.price-o1.price));
        this.q=new PriorityQueue<>((o1,o2)->(o1.price-o2.price));
    }
    
    public void update(int timestamp, int price) {
        if(map.containsKey(timestamp)){
            map.get(timestamp).price=price;
            p.remove(map.get(timestamp));
            p.offer(map.get(timestamp));
            q.remove(map.get(timestamp));
            q.offer(map.get(timestamp));
        }else{
            Node n=new Node(timestamp,price);
            if(t==null||timestamp>t.timestamp){
                t=n;
            }
            map.put(timestamp,n);
            p.offer(n);
            q.offer(n);
        }
        
    }
    
    public int current() {
        return t.price;
    }
    
    public int maximum() {
        return p.peek().price;
    }
    
    public int minimum() {
        return q.peek().price;
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