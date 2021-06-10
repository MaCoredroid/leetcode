/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> lorder=new ArrayList<>();
    List<Integer> Sorder=new ArrayList<>();
    int maxElement,lnull,rnull;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        findMax(root);
        findMax(subRoot);
        lnull=maxElement+1;
        rnull=maxElement+2;
        encode(root,lorder);
        encode(subRoot,Sorder);
        return kmp();
    }

    private void findMax(TreeNode root){
        if(root==null){
            return;
        }
        maxElement=Math.max(maxElement,root.val);
        findMax(root.left);
        findMax(root.right);
    }

    private void encode(TreeNode root,List<Integer> res){
        if(root==null){
            return;
        }
        res.add(root.val);
        if(root.left==null){
            res.add(lnull);
        }else{
            encode(root.left,res);
        }
        if(root.right==null){
            res.add(rnull);
        }else{
            encode(root.right,res);
        }
    }

    private boolean kmp(){
        int slen=Sorder.size();
        int llen=lorder.size();
        int[] fail=new int[slen];
        Arrays.fill(fail,-1);
        for(int i=1,j=-1;i<slen;i++){
            while(j!=-1&&!(Sorder.get(i).equals(Sorder.get(j+1)))){
                j=fail[j];
            }
            if(Sorder.get(i).equals(Sorder.get(j+1))){
                j++;
            }
            fail[i]=j;
        }
        for(int i=0,j=-1;i<llen;i++){
            while(j!=-1&&!(lorder.get(i).equals(Sorder.get(j+1)))){
                j=fail[j];
            }
            if(lorder.get(i).equals(Sorder.get(j+1))){
                j++;
            }
            if(j==slen-1){
                return true;
            }
        }
        return false;
    }


}