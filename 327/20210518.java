class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum = 0;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }
        long lbound=Long.MAX_VALUE;
        long rbound=Long.MIN_VALUE;
        for(long x:preSum){
            lbound=Math.min(Math.min(lbound,x),Math.min(x-lower,x-upper));
            rbound=Math.max(Math.max(rbound,x),Math.max(x-lower,x-upper));
        }
        Node root=new Node(lbound,rbound);
        int ret=0;
        for(long x:preSum){
            ret+=count(root,x-upper,x-lower);
            insert(root,x);

        }
        return ret;
    }

    public void insert(Node root, long val){
        root.val++;
        if(root.left==root.right){
            return;
        }
        long mid=(root.left+root.right)>>1;
        if(val<=mid){
            if(root.lchild==null){
                root.lchild=new Node(root.left,mid);
            }
            insert(root.lchild,val);
        }else{
            if(root.rchild==null){
                root.rchild=new Node(mid+1,root.right);
            }
            insert(root.rchild,val);
        }
    }

    public int count(Node root,long left,long right){
        if(root==null){
            return 0;
        }
        if(left>root.right||right<root.left){
            return 0;
        }
        if(left<=root.left&&root.right<=right){
            return root.val;
        }
        return count(root.lchild,left,right)+count(root.rchild,left,right);
    }
}

class Node{
    long left,right;
    int val;
    Node lchild,rchild;
    public Node(long left,long right){
        this.left=left;
        this.right=right;
        this.val=0;
        this.lchild=null;
        this.rchild=null;
    }
}