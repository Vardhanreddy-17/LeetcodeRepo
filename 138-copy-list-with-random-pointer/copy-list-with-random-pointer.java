/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> mp = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            Node nn = new Node(temp.val);
            mp.put(temp,nn);
            temp = temp.next;
        }
        temp = head;
        Node dummy = new Node(-1);
        Node tail = dummy;
        while(temp!=null){
            Node deepCopy = mp.get(temp);
            deepCopy.next = mp.get(temp.next);
            deepCopy.random = mp.get(temp.random);
            tail.next = deepCopy;
            tail = deepCopy;
            temp = temp.next;
        }
        return dummy.next;
    }
}