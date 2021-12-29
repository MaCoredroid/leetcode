class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        Node[] res=new Node[n];
        for(int i=0;i<speed.length;i++){
            res[i]=new Node(position[i],speed[i]);
        }
        Arrays.sort(res,(o1,o2)->(o1.p-o2.p));
        double prev=0.0;
        int cnt=0;
        for(int i=res.length-1;i>=0;i--){
            double time=(target-res[i].p)/(double)res[i].v;
            if(time>prev){
                prev=time;
                cnt++;
            }
        }
        return cnt;
    }
}

class Node{
    int p;
    int v;
    public Node(int p,int v){
        this.p=p;
        this.v=v;
    }
}