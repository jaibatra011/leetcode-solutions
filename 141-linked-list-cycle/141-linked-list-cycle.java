/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode temp1=head;
        ListNode temp2=head.next;
        while(temp1!=null && temp2!=null && temp2.next!=null && temp1!=temp2){
            temp1=temp1.next;
            temp2=temp2.next.next;
        }
        if(temp1==null || temp2==null || temp2.next==null)
            return false;
        return true;
    }
}