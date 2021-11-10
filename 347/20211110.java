class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            if(!map.containsKey(num)){
                map.put(num,0);
            }
            map.put(num,map.get(num)+1);
        }
        PriorityQueue<Node> pq=new PriorityQueue<Node>((o1,o2)->(o1.val-o2.val));
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            pq.offer(new Node(e.getKey(),e.getValue()));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] ret=new int[k];
        int p=0;
        while(pq.size()>0){
            ret[p++]=pq.poll().key;
        }
        return ret;
    }
}

class Node{
    int key;
    int val;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}