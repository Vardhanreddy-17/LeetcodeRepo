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
    public int pairSum(ListNode head) {
        if(head==null){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        ListNode temp = head;
        ListNode mid = findmid(temp);
        ListNode middle = mid.next;
        mid.next=null;
        ListNode revLast = reverse(middle);
        while(revLast!=null){
            max = Math.max(max,head.val+revLast.val);
            head = head.next;
            revLast = revLast.next;
        }
        return max;
    }
    public ListNode findmid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode c=head;
        ListNode n = null;
        ListNode p = null;
        while(c!=null){
            n = c.next;
            c.next = p;
            p=c;
            c=n;
        }
        return p;
    }
}