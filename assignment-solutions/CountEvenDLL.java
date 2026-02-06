package assignment_solutions;

/**
 * Problem:
 * Count the number of even values in a Doubly Linked List using recursion.
 *
 * Assumption:
 * - The list stores Integer values.
 *
 * Approach:
 * - Check current node
 * - Add 1 if even
 * - Recurse on the next node
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class CountEvenDLL {

    public static int countEven(Node head) {

        // Base case: end of list
        if (head == null) {
            return 0;
        }

        int count = ((int) head.element % 2 == 0) ? 1 : 0;

        return count + countEven(head.next);
    }
}
