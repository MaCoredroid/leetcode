class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int max=nums[0],min=nums[0];
        for(int num:nums){
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        Node root=new Node(min,max);
        for(int num:nums){
            int[] res=query(root,num-1);
            insert(root,num,new int[]{res[0]+1,res[1]});
        }
        return root.res[1];

    }
    public void insert(Node node,int key,int[] res){
        if(node.left==node.right){
            node.res=merge(res,node.res);
            return;
        }else if(key<=node.mid){
            insert(node.getLeftNode(),key,res);
        }else{
            insert(node.getRightNode(),key,res);
        }
        node.res=merge(node.getLeftNode().res,node.getRightNode().res);
    }
    public int[] merge(int[] res1,int[] res2){
        if(res1[0]==res2[0]){
            if(res1[0]==0){
                return new int[]{0,1};
            }
            return new int[]{res1[0],res1[1]+res2[1]};
        }
        return res1[0]>res2[0]?res1:res2;
    }
    public int[] query(Node node,int key){
        if(node.right<=key){
            return node.res;
        }else if(node.left>key){
            return new int[]{0,1};
        }else{
            return merge(query(node.getLeftNode(),key),query(node.getRightNode(),key));
        }
    }
}

class Node{
    int left,right,mid;
    Node leftNode,rightNode;
    int[] res;
    public Node(int start,int end){
        this.left=start;
        this.right=end;
        this.mid=start+((end-start)>>1);
        leftNode=null;
        rightNode=null;
        res=new int[]{0,1};
    }

    public Node getLeftNode(){
        if(leftNode==null){
            leftNode=new Node(left,mid);
        }
        return leftNode;
    }

    public Node getRightNode(){
        if(rightNode==null){
            rightNode=new Node(mid+1,right);
        }
        return rightNode;
    }
}