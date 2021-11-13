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
    public TreeNode str2tree(String s) {
        if(s.length()==0){
            return null;
        }
        int i=0;
        while(i<s.length()&&s.charAt(i)!='('){
            i++;
        }
        TreeNode root=new TreeNode(Integer.parseInt(s.substring(0,i)));
        if(i==s.length()){
            return root;
        }
        int j=i+1;
        int cnt=1;
        while(cnt>0&&j<s.length()){
            if(s.charAt(j)=='('){
                cnt++;
            }else if(s.charAt(j)==')'){
                cnt--;
            }
            j++;
        }
        root.left=str2tree(s.substring(i+1,j-1));
        if(j==s.length()){
            return root;
        }
        root.right=str2tree(s.substring(j+1,s.length()-1));
        return root;
        
    }
}