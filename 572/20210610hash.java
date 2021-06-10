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
    static final int MAX_N = 1005;
    static final int MOD = 1000000007;
    boolean[] vis = new boolean[MAX_N];
    int[] p = new int[MAX_N];
    int tot;
    Map<TreeNode, int[]> hS = new HashMap<TreeNode, int[]>();
    Map<TreeNode, int[]> hT = new HashMap<TreeNode, int[]>();
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        getPrime();
        dfs(root, hS);
        dfs(subRoot, hT);

        int tHash = hT.get(subRoot)[0];
        for (Map.Entry<TreeNode, int[]> entry : hS.entrySet()) {
            if (entry.getValue()[0] == tHash) {
                return true;
            }
        }

        return false;
    }

    private void getPrime(){
        vis[0]=vis[1]=true;
        tot=0;
        for(int i=2;i<MAX_N;i++){
            if(!vis[i]){
                p[++tot]=i;
            }
            for(int j=1;j<=tot&&i*p[j]<MAX_N;j++){
                vis[i*p[j]]=true;
                if(i%p[j]==0){
                    break;
                }
            }
        }
    }

    private void dfs(TreeNode root, Map<TreeNode, int[]> map){
        map.put(root,new int[]{root.val,1});
        if(root.left!=null){
            dfs(root.left,map);
            int[] val=map.get(root);
            val[1]+=map.get(root.left)[1];
            val[0]+=(int) ((val[0] + (31L * map.get(root.left)[0] * p[map.get(root.left)[1]]) % MOD) % MOD);
        }
        if(root.right!=null){
            dfs(root.right,map);
            int[] val=map.get(root);
            val[1]+=map.get(root.right)[1];
            val[0]+=(int) ((val[0] + (179L * map.get(root.right)[0] * p[map.get(root.right)[1]]) % MOD) % MOD);
        }
        

    }
}