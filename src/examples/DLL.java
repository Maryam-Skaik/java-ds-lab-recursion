package recursion;

/**
 * Doubly Linked List (DLL) class demonstrating:
 * - Insert at head and tail
 * - Delete by value
 * - Forward and backward traversal (iterative and recursive)
 * - Node swapping
 */
public class DLL<T> {

    public Node<T> head;
    public Node<T> tail;
    int size;

    public DLL() { head = null; tail = null; size = 0; }

    /** Node class for DLL */
    public static class Node<T> {
        private T element;
        private Node<T> next;
        private Node<T> prev;

        public Node(T e, Node<T> n, Node<T> p) { element = e; next = n; prev = p; }
        public T getElement() { return element; }
        public Node<T> getNext() { return next; }
        public Node<T> getPrev() { return prev; }
        public void setNext(Node<T> n) { next = n; }
        public void setPrev(Node<T> p) { prev = p; }
    }

    /** Insert node at head */
    public void insertAtHead(Node<T> node){
        if(head == null){ head = node; tail = node; size++; return; }
        node.next = head;
        head.prev = node;
        head = node;
        size++;
    }

    /** Insert node at tail */
    public void insertAtTail(Node<T> node){
        if(head == null){ head = node; tail = node; size++; return; }
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }

    /** Delete node by value */
    public void deleteByValue(T element){
        if(head == null) return;
        if(head.element.equals(element)){
            if(head == tail){ head = null; tail = null; size--; return; }
            head = head.next; head.prev = null; size--; return;
        }
        if(tail.element.equals(element)){ tail = tail.prev; tail.next = null; size--; return; }

        Node<T> current = head;
        while(current != null && !current.element.equals(element)) current = current.next;
        if(current != null){ current.prev.next = current.next; current.next.prev = current.prev; size--; }
    }

    /** Traverse forward iteratively */
    public void TraverseForward(){
        Node<T> current = head;
        System.out.print("NULL <-> ");
        while(current != null){ System.out.print(current.element + " <-> "); current = current.next; }
        System.out.println("NULL");
    }

    /**
     * Prints elements of a doubly linked list from head to tail using recursion.
     * 
     * How it works:
     * 1. Base Case: If the current node is null, we reached the end, so stop recursion.
     * 2. Recursive Step: Print the current node's element, then call the method on the next node.
     * 
     * Example with list: 1 <-> 2 <-> 3 <-> NULL
     * TraverseForwardRec(head)
     *   prints 1
     *   TraverseForwardRec(2)
     *     prints 2
     *     TraverseForwardRec(3)
     *       prints 3
     *       TraverseForwardRec(null)
     *         stops recursion
     */
    public void TraverseForwardRec(Node node){
        if(node == null) return;       // base case: end of list
        System.out.print(node.element + " "); // process current node
        TraverseForwardRec(node.next); // recursive step: move to next node
    }


    /** Traverse backward iteratively */
    public void TraverseBackward(){
        Node<T> current = tail;
        System.out.print("NULL <-> ");
        while(current != null){ System.out.print(current.element + " <-> "); current = current.prev; }
        System.out.println("NULL");
    }

    /**
     * Prints elements of a doubly linked list from tail to head using recursion.
     * 
     * How it works:
     * 1. Base Case: If the current node is null, we reached the start, so stop recursion.
     * 2. Recursive Step: Print the current node's element, then call the method on the previous node.
     * 
     * Example with list: NULL <-> 1 <-> 2 <-> 3 <-> tail
     * TraverseBackwardRec(tail)
     *   prints 3
     *   TraverseBackwardRec(2)
     *     prints 2
     *     TraverseBackwardRec(1)
     *       prints 1
     *       TraverseBackwardRec(null)
     *         stops recursion
     */
    public void TraverseBackwardRec(Node node){
        if(node == null) return;       // base case: start of list reached
        System.out.print(node.element + " "); // process current node
        TraverseBackwardRec(node.prev); // recursive step: move to previous node
    }

    /** Get size */
    public int size(){ return size; }

    /** Swap two nodes */
    public void swapNodes(Node x, Node y){
        if(x == null || y == null || x == y) return;
        if(x.prev != null) x.prev.next = y; else head = y;
        if(y.prev != null) y.prev.next = x; else head = x;
        if(x.next != null) x.next.prev = y; else tail = y;
        if(y.next != null) y.next.prev = x; else tail = x;

        Node prev = x.prev; Node next = x.next;
        x.prev = y.prev; x.next = y.next;
        y.prev = prev; y.next = next;
    }

    public static void main(String[] args){
        DLL<Integer> dll = new DLL<>();
        Node<Integer> a = new Node<>(1, null, null);
        Node<Integer> b = new Node<>(2, null, null);
        Node<Integer> c = new Node<>(3, null, null);
        Node<Integer> d = new Node<>(4, null, null);

        dll.insertAtHead(d);
        dll.insertAtHead(c);
        dll.insertAtHead(b);
        dll.insertAtHead(a);

        System.out.println("Forward Recursive:");
        dll.TraverseForwardRec(a);
        System.out.println("\nBackward Recursive:");
        dll.TraverseBackwardRec(d);
    }
}
