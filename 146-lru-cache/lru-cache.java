class LRUCache {
    int capacity;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    Map<Integer,Node> mp = new HashMap<>();

    private static class Node {
        Node prev;
        Node next;
        int key;
        int value;
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;
        Node temp = mp.get(key);
        remove(temp);
        insert(temp);
        return temp.value;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node temp = mp.get(key);
            temp.value = value;
            remove(temp);
            insert(temp);
            return;
        }else{
            if(mp.size()==capacity){
                Node temp = tail.prev;
                remove(temp);
            }
            Node nn = new Node(key,value);
            insert(nn);
        }
    }
    private void remove(Node node){
            mp.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void insert(Node node){
            mp.put(node.key,node);
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.prev = head;

        }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */