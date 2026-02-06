package assignment_solutions;

/**
 * Problem:
 * Insert a value at the end of a Singly Linked List using recursion.
 *
 * Approach:
 * - If list is empty, create and return a new node
 * - Otherwise, recursively insert into the next node
 *
 * Important:
 * - The recursion travels until the last node
 * - On unwinding, links are preserved
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) due to recursion stack
 */
public class InsertEndSLL {

    public static Node insertEnd(Node head, int value) {

        // Base case: empty list or end reached
        if (head == null) {
            return new Node(value);
        }

        // Recursive call on next node
        head.next = insertEnd(head.next, value);

        return head;
    }
}
