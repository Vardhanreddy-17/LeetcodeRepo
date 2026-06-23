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
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        ListNode even = evenHead;
        ListNode odd = oddHead;
        ListNode temp = head;
        int i = 1;
        while(temp!=null){
            if(i%2!=0){
                ListNode nn = new ListNode(temp.val);
                odd.next = nn;
                odd=nn;
            }else{
                ListNode nn = new ListNode(temp.val);
                even.next = nn;
                even=nn;
            }
            temp = temp.next;
            i++;
        }
        odd.next = (evenHead.next != null) ? evenHead.next : null;
        return oddHead.next;
    }
}