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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode ans, temp, temp1, temp2;
        temp1=list1;
        temp2=list2;
        if(temp1.val<temp2.val){ // finding head of new list
            ans=temp1;
            temp=ans;
            temp1=temp1.next;
        }
        else{
            ans=temp2;
            temp=ans;
            temp2=temp2.next;
        }
        while(temp1!=null && temp2!=null){ //adding elements till one of the list ends
            if(temp1.val<temp2.val){
                temp.next=temp1;
                temp1=temp1.next;
                temp=temp.next;
            }
            else{
                temp.next=temp2;
                temp2=temp2.next;
                temp=temp.next;
            }
        }
        if(temp1==null){ // if temp1 ends, add elements of temp2
            temp.next=temp2;
        }else{ // if temp2 ends, add elements of temp1
            temp.next=temp1;
        }
        return ans;
    }
}