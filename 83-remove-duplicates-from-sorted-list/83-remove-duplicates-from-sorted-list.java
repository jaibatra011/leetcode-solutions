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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode prev=head, curr=head.next;
        while(curr!=null){
            if(prev.val==curr.val){ // if equal, delete curr by pointing prev next to curr next
                prev.next=curr.next;
            }
            else{ // else move to next node
                prev=curr;
            }
            curr=curr.next; // move curr to next node in any case
        }
        return head;
    }
}