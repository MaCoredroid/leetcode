/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        List<Integer> res =new ArrayList<>();
        while(head!=null){
            res.add(head.val);
            head=head.next;
        }
        int[] ans=new int[res.size()];
        Arrays.fill(ans,0);
        for(int i=0;i<res.size();i++){
            while(!stack.isEmpty()&&res.get(stack.peek())<res.get(i)){
                ans[stack.peek()]=res.get(i);
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
        
    }
}