/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len=lists.length;
        if(len==0)
        {
            return null;
        }
        while(len>1)
        {
            for(int i=0;i<len/2;i++)
            {
                lists[i]=mergeTwoLists(lists[i],lists[len-1-i]);
            }
            len=(len+1)/2;
        }
        return lists[0];
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        ListNode root=new ListNode(0);
        ListNode ret=root;
        while(l1!=null||l2!=null)
        {
            if(l1==null)
            {
                root.next=new ListNode(l2.val);
                root=root.next;
                l2=l2.next;
                continue;
            }
            if(l2==null)
            {
                root.next=new ListNode(l1.val);
                root=root.next;
                l1=l1.next;
                continue;
            }
            if(l1.val<l2.val)
            {
                root.next=new ListNode(l1.val);
                root=root.next;
                l1=l1.next;
                continue;
            }
            else
            {
                root.next=new ListNode(l2.val);
                root=root.next;
                l2=l2.next;
                continue;
            }
        }




        return ret.next;
    }
}