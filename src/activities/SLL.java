/**
 * Singly Linked List (SLL) implementation for Recursion Activities.
 *
 * This class is used in the Data Structures Lab to demonstrate how
 * recursion can be applied to linked list problems such as:
 * - counting nodes
 * - summing elements
 * - reversing a list
 *
 * The focus is on understanding base cases, recursive calls,
 * and how the call stack behaves with linked structures.
 *
 * @author Maryam
 */
public class SLL<T> {

    /** Reference to the first node of the list */
    public Node<T> head;

    /** Maintains the size of the list (used for iterative comparisons) */
    private int size;

    /**
     * Constructs an empty singly linked list.
     */
    public SLL() {
        head = null;
        size = 0;
    }

    /**
     * Node class represents a single element in the list.
     * Each node stores data and a reference to the next node.
     */
    public static class Node<T> {
        private T element;      // data stored in the node
        private Node<T> next;   // reference to the next node

        public Node(T e) {
            element = e;
            next = null;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> n) {
            next = n;
        }
    }

    /**
     * Inserts a node at the beginning of the list.
     * Time Complexity: O(1)
     */
    public void insertAtHead(Node<T> node) {
        node.next = head;   // new node points to old head
        head = node;        // head updated
        size++;
    }

    /**
     * Inserts a node at the end of the list.
     * Time Complexity: O(n)
     */
    public void insertAtTail(Node<T> node) {
        if (head == null) {
            insertAtHead(node);
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
        size++;
    }

    /**
     * Iterative method to count nodes (used for comparison with recursion).
     * Time Complexity: O(n)
     */
    public int countNodes() {
        int count = 0;
        Node<T> current = head;

        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Counts the number of nodes recursively.
     *
     * Base Case:
     * - When node == null → end of list reached
     *
     * Recursive Case:
     * - Count current node + count of remaining list
     *
     * Time: O(n)
     * Space: O(n) (recursive stack)
     */
    public int countNodesRec(Node<T> node) {
        if (node == null)
            return 0;
        return 1 + countNodesRec(node.next);
    }

    /**
     * Recursively computes the sum of all elements in the list.
     * Assumes list stores Integer values.
     *
     * Base Case:
     * - node == null → sum = 0
     */
    public int sumNodes(Node<T> node) {
        if (node == null)
            return 0;
        return (Integer) node.element + sumNodes(node.next);
    }

    /**
     * Recursively reverses the singly linked list.
     *
     * Base Case:
     * - Empty list or single node → already reversed
     *
     * Recursive Logic:
     * - Reverse remaining list
     * - Fix pointers while backtracking
     */
    public Node<T> reverseList(Node<T> node) {
        if (node == null || node.next == null)
            return node;

        Node<T> newHead = reverseList(node.next);

        // reverse the link
        node.next.next = node;
        node.next = null;

        return newHead;
    }

    /**
     * Returns the size of the list.
     */
    public int size() {
        return size;
    }
}
