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
    private boolean isPalindromeHelper(ListNode right){
        if(right==null){
            return true;
        }
        boolean res=isPalindromeHelper(right.next);
        if(res==false){
            return false;
        }else if(left.val!=right.val){
            return false;
        }else{
            left=left.next;
            return true;
        }
    }
    ListNode left=null;
    public boolean isPalindrome(ListNode head) {
        left=head;
        return isPalindromeHelper(head);
    }
}