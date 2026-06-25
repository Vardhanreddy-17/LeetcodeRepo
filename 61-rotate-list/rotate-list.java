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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        int total = 1;
        ListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
            total++;
        }
        k%=total;
        k = total - k;
        temp.next = head;
        while(k-->0){
            temp = temp.next;
        }
        ListNode nn= temp.next;
        temp.next = null;
        return nn;
    }
}