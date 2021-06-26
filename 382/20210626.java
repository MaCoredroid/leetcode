/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode head;
    Random random;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head=head;
        this.random=new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int count=0;
        ListNode curr=head;
        int reserve=0;
        while(curr!=null){
            count++;
            int r=random.nextInt(count)+1;
            if(r==count){
                reserve=curr.val;
            }
            curr=curr.next;
        }
        return reserve;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */