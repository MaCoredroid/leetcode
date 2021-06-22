class Skiplist {
    private Node head;
    public Skiplist() {
        Node[] left = new Node[16];
        Node[] right = new Node[16];
        for(int i = 0; i < 16; i++){
            left[i] = new Node(-1);
            right[i] = new Node(20001);
        }
        for(int i = 0; i < 15; i++){
            left[i].right = right[i];
            left[i].down = left[i + 1];
            right[i].down = right[i + 1];
        }
        left[15].right = right[15];
        head = left[0];
    }
    
    public boolean search(int target) {
        Node cur=head;
        while(cur!=null){
            if(cur.right.val>target){
                cur=cur.down;
            }else if(cur.right.val<target){
                cur=cur.right;
            }else{
                return true;
            }
        }
        return false;
    }
    
    public void add(int num) {
        Node cur=head;
        Deque<Node> stack=new LinkedList<>();
        while(cur!=null){
            if(cur.right.val>num){
                stack.push(cur);
                cur=cur.down;
            }else{
                cur=cur.right;
            }
        }
        Node pre=null;
        while(!stack.isEmpty()){
            cur=stack.pop();
            Node node=new Node(num);
            node.right=cur.right;
            cur.right=node;
            if(pre!=null){
                node.down=pre;
            }
            pre=node;
            if(Math.random()<0.5){
                break;
            }
        }

    }
    
    public boolean erase(int num) {
        Node cur=head;
        boolean isDeleted=false;
        while(cur!=null){
            if(cur.right.val>=num){
                if(cur.right.val==num){
                    isDeleted=true;
                    cur.right=cur.right.right;
                }
                cur=cur.down;
            }else{
                cur=cur.right;
            }
        }
        return isDeleted;
    }
}

class Node{
    int val;
    Node right;
    Node down;

    public Node(int val){
        this.val = val;
    }
}
/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */