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
    class Status implements Comparable<Status>{
        int val; 
        ListNode ptr;

        Status(int val,ListNode ptr)
        {
            this.val=val;
            this.ptr=ptr;
        }

        public int compareTo(Status status)
        {
            return this.val-status.val;
        }
    }

    PriorityQueue<Status> queue=new PriorityQueue<Status>();
    public ListNode mergeKLists(ListNode[] lists) {
        for(ListNode node:lists)
        {
            if(node!=null)
            {
                queue.add(new Status(node.val,node));
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode head=dummy;
        while(!queue.isEmpty()){
            Status temp=queue.poll();
            head.next=temp.ptr;
            head=head.next;
            if(temp.ptr.next!=null)
            {
                queue.add(new Status(temp.ptr.next.val,temp.ptr.next));
            }
        }
        return dummy.next;
    }

   
}