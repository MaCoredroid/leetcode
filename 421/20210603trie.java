class Solution {
    Trie root=new Trie();
    static final int HIGH_BIT = 30;
    public int findMaximumXOR(int[] nums) {
        int n=nums.length;
        int x=0;
        for(int i=1;i<nums.length;i++){
            add(nums[i-1]);
            x=Math.max(x,check(nums[i]));
        }
        return x;
    }

    private void add(int num){
        Trie cur=root;
        for(int i=HIGH_BIT;i>=0;i--){
            int bit=(num>>i)&1;
            if(bit==0){
                if(cur.left==null){
                    cur.left=new Trie();
                }
                cur=cur.left;
            }else{
                if(cur.right==null){
                    cur.right=new Trie();
                }
                cur=cur.right;
            }
        }
    }

    private int check(int num){
        Trie cur=root;
        int x=0;
        for(int i=HIGH_BIT;i>=0;i--){
            int bit=(num>>i)&1;
            if(bit==0){
                if(cur.right!=null){
                    cur=cur.right;
                    x=2*x+1;
                }else{
                    cur=cur.left;
                    x=2*x;
                }
            }else{
                if(cur.left!=null){
                    cur=cur.left;
                    x=2*x+1;
                }else{
                    cur=cur.right;
                    x=2*x;
                }
            }
        }
        return x;
    }
}

class Trie{
    Trie left=null;
    Trie right=null;
    public Trie(){

    }
}