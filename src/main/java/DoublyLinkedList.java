
public class DoublyLinkedList {


    private Node head,tail;
    private int size;

    public DoublyLinkedList(){

        head = new Node(0, "");
        tail = new Node(0, "");
        head.next = tail;
        tail.pre = head;

        size = 0;
    }

    public void addNodeLast(Node x) {
        x.pre = tail.pre;
        x.next = tail;
        tail.pre.next = x;
        tail.pre = x;

        size++;
    }

    public Node removeFirst() {
        if (head.next == tail) {  // empty
            return null;
        }
        Node firstNode = head.next;
        removeNode(firstNode);
        size --;
        return firstNode;
    }

    public int getSize() {
        return size;
    }

    public void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size --;
    }


    public void printDllNodes() {

        if (head.next == tail ) {
            System.out.println("Doubly linked list is empty");
            return;
        }
        System.out.println("\n>>>>>>output start");
        System.out.println("Total: " + size);
        Node current = head.next;
        while(current != tail) {
            System.out.printf("%s:%s ", current.key ,current.val);
            current = current.next;
        }
        System.out.println("\n<<<<<<output end\n");
    }
}
