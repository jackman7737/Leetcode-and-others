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
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        
        ListNode temp = head;
        ListNode head1 = new ListNode(0);
        ListNode prev = head1;
        
        while(temp != null){
            if(temp.val < x){
                    prev.next = new ListNode(temp.val,null);
                    prev = prev.next;
            }
            
            temp = temp.next;
        }
        
        temp = head;
        while(temp != null){
            if(temp.val >= x){
                prev.next = new ListNode(temp.val,null);
                    prev = prev.next;
            }
            temp = temp.next;
        }
        
        return head1.next;
    }
}