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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid = find(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = head;
        left = sortList(left);
        right = sortList(right);
        return mergeSortHelper(left,right);
    }
    public ListNode find(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode mergeSortHelper(ListNode left,ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(left!=null && right!=null){
            if(left.val<=right.val){
                tail.next = left;
                tail = left;
                if(left!=null){
                    left = left.next;
                }
            }else{
                tail.next = right;
                tail = right;
                if(right!=null){
                    right = right.next;
                }
            }
        }
        if(left!=null){
            tail.next = left;
        }
        if(right!=null){
            tail.next = right;
        }
        return dummy.next;
    }
}