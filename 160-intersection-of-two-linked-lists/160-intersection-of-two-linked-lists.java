/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 
public class Solution {
    public ListNode getIntersectionNode(ListNode one, ListNode two) {
        ListNode otemp =one;
        ListNode ttemp =two;
        int lenA= length(one);
        int lenB= length(two);
        int gap= lenA-lenB;
        if(lenA>lenB){
            for(int i=0;i<gap;i++){
                otemp=otemp.next;
            }
        }else if(lenB>lenA){
            for(int i=0;i<gap;i++){
                ttemp=ttemp.next;
            }
        }
        while(otemp!=ttemp){
            otemp=otemp.next;
            ttemp=ttemp.next;
        }
        return otemp;
    }
    
    private int length(ListNode node) {
    int length = 0;
    while (node != null) {
        node = node.next;
        length++;
    }
    return length;
}
} */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
 if(headA == null || headB == null)
    {
        return null;    // no intersection is possible
    }
    
    ListNode tempA = headA;
    ListNode tempB = headB;
    
    while(tempA != tempB)
    {
        if(tempA == null)
        {
            tempA = headB;
        }
        else
        {
            tempA = tempA.next;
        }
        
        if(tempB == null)
        {
            tempB = headA;
        }
        else
        {
            tempB = tempB.next;
        }
    }
    
    return tempA;
    }
}