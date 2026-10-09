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
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode left = head;
        ListNode newRightHead = reverse(right);
        while(left!=null && newRightHead!=null){
            if(left.val!=newRightHead.val){
                return false;
            }
            left = left.next;
            newRightHead = newRightHead.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode c = head;
        ListNode n = null;
        ListNode p = null;
        while(c!=null){
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }
}