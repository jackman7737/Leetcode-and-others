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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode handler = head;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                handler.next = l1;
                l1 = l1.next;
            } else {
                handler.next = l2;
                l2 = l2.next;
            }
            handler = handler.next;
        }
        
        if (l1 != null) {
            handler.next = l1;
        } else if (l2 != null) {
            handler.next = l2;
        }
        
        return head.next;
    }
     public ListNode mergeKLists(ListNode[] lists, int si, int ei) {
        if(si==ei) return lists[si];
         int mid=(si+ei)/2;
         ListNode l1= mergeKLists(lists,si,mid);
         ListNode l2= mergeKLists(lists,mid+1,ei);
         return mergeTwoLists(l1,l2);
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        return mergeKLists(lists,0,lists.length-1);
    }
}