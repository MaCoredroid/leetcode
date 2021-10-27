/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */

class Solution {
     public $ans=null;
    /**
     * @param TreeNode $root
     * @param TreeNode $p
     * @param TreeNode $q
     * @return TreeNode
     */
    function dfs($root, $p, $q){
        if($root==null){
            return false;
        }
        $flag1=$this->dfs($root->left,$p,$q);
        $flag2=$this->dfs($root->right,$p,$q);
        if($root->val=== $p||$root->val=== $q){
            if($flag1||$flag2){
                $this->ans=$root;
            }
            return true;
        }
        
        if($flag1&&$flag2){
            $this->ans=$root;
        }
        return $flag1||$flag2;
    }
    
    function lowestCommonAncestor($root, $p, $q) {
        $this->dfs($root,$p->val,$q->val);
        return $this->ans;
    }
    
    
}