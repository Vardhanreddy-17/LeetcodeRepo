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
        Node temp = head;
        Map<Node,Node> mp = new HashMap<>();
        while(temp!=null){
            Node deepCopy = new Node(temp.val);
            mp.put(temp,deepCopy);
            temp = temp.next;
        }
        Node nn = new Node(-1);
        Node tail = nn;
        temp = head;
        while(temp!=null){
            Node deepCopy = mp.get(temp);
            deepCopy.next = mp.get(temp.next);
            deepCopy.random = mp.get(temp.random);
            tail.next = deepCopy;
            tail = deepCopy;
            temp = temp.next;
        }
        return nn.next;
    }

}