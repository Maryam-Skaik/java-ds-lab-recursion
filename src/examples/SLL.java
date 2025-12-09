package recursion;

/**
 * Singly Linked List (SLL) class demonstrating:
 * - Insertions at head and tail
 * - Deletion by value
 * - Traversal
 * - Counting nodes iteratively and recursively
 * - Finding nth node from end
 */
public class SLL<T> {

    public Node<T> head;
    int size;

    public SLL() {
        head = null;
        size = 0;
    }

    /**
     * Node class for SLL.
     */
    public static class Node<T> {
        private T element;
        private Node<T> next;

        public Node(T e, Node<T> n) {
            element = e;
            next = n;
        }

        public Node(T e) { element = e; next = null; }

        public T getElement() { return element; }
        public Node<T> getNext() { return next; }
        public void setNext(Node<T> n) { next = n; }
    }

    /** Insert node at head */
    public void insertAtHead(Node<T> node) {
        node.next = head;
        head = node;
        size++;
    }

    /** Insert node at tail */
    public void insertAtTail(Node<T> node) {
        if (head == null) { insertAtHead(node); return; }
        Node<T> current = head;
        while (current.next != null) current = current.next;
        current.next = node;
        size++;
    }

    /** Delete node by value */
    public void deleteByValue(T element) {
        if(head == null) return;
        if(head.element.equals(element)) { head = head.next; size--; return; }
        Node<T> current = head;
        while(current.next != null && !current.next.element.equals(element))
            current = current.next;
        if(current.next != null) current.next = current.next.next;
        size--;
    }

    /** Print list iteratively */
    public void printList() {
        Node<T> current = head;
        while(current != null) { System.out.print(current.element + " -> "); current = current.next; }
        System.out.println("NULL");
    }

    /** Count nodes iteratively */
    public int countNodes() {
        Node current = head;
        int count = 0;
        while(current != null) { count++; current = current.next; }
        return count;
    }

    /**
     * Counts the number of nodes in a singly linked list recursively.
     * 
     * How it works:
     * 1. Base Case: If the current node is null, we reached the end of the list, so return 0.
     * 2. Recursive Step: Otherwise, return 1 (for the current node) plus the count of nodes in the rest of the list.
     * 
     * Example with list: 1 -> 2 -> 3 -> NULL
     * countNodesRec(head) 
     *   = 1 + countNodesRec(2)
     *   = 1 + (1 + countNodesRec(3))
     *   = 1 + (1 + (1 + countNodesRec(null)))
     *   = 1 + (1 + (1 + 0))
     *   = 3
     */
    public int countNodesRec(Node node) {
        if(node == null) return 0; // base case: end of list
        return 1 + countNodesRec(node.next); // recursive step: count current + rest
    }


    /** Get size */
    public int size() { return size; }

    /** Print nth node from end */
    public T printNthFromEnd(int k){
        if(k > size || k <= 0) return null;
        int nth = size - k;
        Node current = head;
        for(int i = 0; i < nth; i++) current = current.next;
        return (T) current.element;
    }

    /** Another method to get nth node from end using two pointers */
    public T nthNodeFromEnd(int k){
        if(k > size || k <= 0) return null;
        Node first = head;
        Node second = head;
        for(int i = 0; i < k; i++) first = first.next;
        while(first != null){ first = first.next; second = second.next; }
        return (T) second.element;
    }

    public static void main(String[] args) {
        SLL<Integer> sll = new SLL<>();
        sll.insertAtHead(new Node<>(5));
        sll.insertAtHead(new Node<>(1));
        sll.insertAtHead(new Node<>(20));
        Node<Integer> node = new Node<>(5);
        sll.insertAtHead(node);
        
        System.out.println(sll.countNodes());
        System.out.println(sll.countNodesRec(node));
    }
}
