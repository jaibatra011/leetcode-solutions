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
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode next=head.next;
        ListNode prev=null;
        while(next!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            next=next.next;
        }
        curr.next=prev;
        return curr;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode temp1=head;
        ListNode temp2=temp1;
        while(temp2!=null && temp2.next!=null){ //find midpoint of linkedlist
            temp1=temp1.next;
            temp2=temp2.next.next;
        }
        temp2=reverse(temp1); //reverse the second half of linkedlist
        temp1=head;
        //if reverse of second half of linkedlist is equal to first half, it is a palindrome
        while(temp1!=temp2){ // due to reverse, last element of both ll will be same
            if(temp1.val!=temp2.val)
                return false;
            temp1=temp1.next;//null is not present in first ll, therefore no need to check
            if(temp2.next!=null) // next of last element has null, therefore check is needed
                temp2=temp2.next;
        }
        return true;
    }
}