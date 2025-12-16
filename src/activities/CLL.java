/**
 * Circular Linked List (CLL) implementation for Recursion Activities.
 *
 * This class is designed for Data Structures Lab students to understand
 * how recursion behaves on circular data structures, where NULL is not
 * available as a natural stopping condition.
 *
 * Key learning focus:
 * - Choosing correct base cases in circular structures
 * - Preventing infinite recursion
 * - Applying recursion safely on CLLs
 *
 * @author Maryam
 */
public class CLL<T> {

    /** Reference to the head node of the circular linked list */
    private Node<T> head;

    /**
     * Constructs an empty circular linked list.
     */
    public CLL() {
        head = null;
    }

    /**
     * Node class represents a single node in the circular linked list.
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
     * Inserts a node at the head of the circular linked list.
     *
     * Special Cases:
     * - Empty list: node points to itself
     * - Non-empty list: last node must update its next reference
     *
     * Time Complexity: O(n)
     */
    public void insertAtHead(Node<T> node) {
        if (head == null) {
            head = node;
            head.next = head;   // circular reference
            return;
        }

        Node<T> current = head;

        // Traverse until the last node (node whose next points to head)
        while (current.next != head) {
            current = current.next;
        }

        current.next = node;   // last node points to new node
        node.next = head;      // new node points to old head
        head = node;           // update head
    }

    /**
     * Inserts a node at the tail of the circular linked list.
     *
     * Time Complexity: O(n)
     */
    public void insertAtTail(Node<T> node) {
        if (head == null) {
            head = node;
            head.next = head;
            return;
        }

        Node<T> current = head;

        // Find the last node
        while (current.next != head) {
            current = current.next;
        }

        current.next = node;   // last node points to new node
        node.next = head;      // new node completes the circle
    }

    /**
     * Deletes the first occurrence of a given value from the list.
     *
     * Handles:
     * - Empty list
     * - Single-node list
     * - Deleting the head node
     */
    public void deleteByValue(T element) {
        if (head == null)
            return;

        // Case 1: deleting the head node
        if (head.element.equals(element)) {
            // Single-node list
            if (head.next == head) {
                head = null;
                return;
            }

            // Copy data from next node and bypass it
            head.element = head.next.element;
            head.next = head.next.next;
            return;
        }

        Node<T> current = head;

        // Search for the node before the one to delete
        while (current.next != head) {
            if (current.next.element.equals(element)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    /**
     * Traverses and prints the circular linked list.
     * Uses do-while to ensure at least one visit to head.
     */
    public void traverse() {
        if (head == null)
            return;

        Node<T> current = head;
        do {
            System.out.print(current.element + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println("(back to head)");
    }

    /**
     * Recursively finds the last node in the circular linked list.
     *
     * IMPORTANT:
     * - NULL is never reached in a CLL
     * - The only safe stopping condition is node.next == head
     *
     * Base Case:
     * - When node.next == head → current node is the last node
     *
     * Time: O(n)
     * Space: O(n)
     */
    public Node<T> findLast(Node<T> head, Node<T> node) {
        if (head == null)
            return null;

        if (node.next == head)
            return node;

        return findLast(head, node.next);
    }

    /**
     * Recursively counts the number of nodes in the circular linked list.
     *
     * Base Case:
     * - When node.next == head → count = 1
     *
     * Recursive Case:
     * - Count current node + count remaining nodes
     *
     * Time: O(n)
     * Space: O(n)
     */
    public int countNodes(Node<T> head, Node<T> node) {
        if (head == null)
            return 0;

        if (node.next == head)
            return 1;

        return 1 + countNodes(head, node.next);
    }
}
