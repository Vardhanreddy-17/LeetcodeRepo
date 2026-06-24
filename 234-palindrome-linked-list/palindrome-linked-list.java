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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = rev(slow.next);
        slow.next=null;
        ListNode first = head;
        ListNode second = mid;
        while(second!=null){
            if(first.val!=second.val){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }
    public ListNode rev(ListNode head){
        ListNode c= head;
        ListNode n = null;
        ListNode p = null;
        while(c!=null){
            n = c.next;
            c.next= p;
            p = c;
            c = n;
        }
        return p;
    }
}