class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            if(!map.containsKey(num)){
                map.put(num,0);
            }
            map.put(num,map.get(num)+1);
        }
        int n=map.size();
        Node[] nodes=new Node[map.size()];
        int p=0;
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            nodes[p++]=new Node(e.getKey(),e.getValue());
        }
        quickselect(nodes,0,n-1,n-k);
        Node[] ans=Arrays.copyOfRange(nodes,n-k,n);
        int[] ret=new int[k];
        for(int i=0;i<k;i++){
            ret[i]=ans[i].key;
        }
        return ret;
    }
    
    public void quickselect(Node[] nodes,int left,int right,int index){
        Node pivot=nodes[left];
        int l=left,r=right;
        while(l<r){
            while(l<r&&nodes[r].val>=pivot.val){
                r--;
            }
            nodes[l]=nodes[r];
            while(l<r&&nodes[l].val<=pivot.val){
                l++;
            }
            nodes[r]=nodes[l];
        }
        nodes[l]=pivot;
        if(l==index){
            return;
        }else if(l<index){
            quickselect(nodes,l+1,right,index);
        }else{
            quickselect(nodes,left,l-1,index);
        }
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