class Solution {
    public int[] getOrder(int[][] tasks) {
        
        Node[] nodes=new Node[tasks.length];
        for(int i=0;i<tasks.length;i++){
            nodes[i]=new Node(i,tasks[i][0],tasks[i][1]);
        }
        
        Arrays.sort(nodes,(o1,o2)->(o1.start-o2.start));
        int time=nodes[0].start;
        PriorityQueue<Node> pq=new PriorityQueue<>((o1,o2)->(o1.weight==o2.weight?o1.id-o2.id:o1.weight-o2.weight));
        int left=0;
        while(left<nodes.length&&nodes[left].start<=time){
            pq.offer(nodes[left++]);
        }
        int[] ans=new int[tasks.length];
        for(int i=0;i<ans.length;i++){
            Node temp=pq.poll();
            ans[i]=temp.id;
            time+=temp.weight;
            while(left<nodes.length&&nodes[left].start<=time){
                pq.offer(nodes[left++]);
            }
            if(pq.isEmpty()&&left<nodes.length){
                time=nodes[left].start;
                while(left<nodes.length&&nodes[left].start<=time){
                    pq.offer(nodes[left++]);
                }
            }
        }
        return ans;
    }
}

class Node{
    int id;
    int start;
    int weight;
    public Node(int id,int start,int weight){
        this.id=id;
        this.start=start;
        this.weight=weight;
    }
}