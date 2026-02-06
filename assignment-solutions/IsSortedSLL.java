package assignment_solutions;

/**
 * Problem:
 * Check whether a Singly Linked List is sorted in ascending order using recursion.
 *
 * Example:
 * 1 → 2 → 3 → 4 → true
 * 1 → 3 → 2 → false
 *
 * Approach:
 * - Compare current node with next node
 * - If order breaks, return false
 * - Otherwise, recurse on the next node
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class IsSortedSLL {

    public static boolean isSorted(Node head) {

        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return true;
        }

        // If current > next, list is not sorted
        if ((int) head.element > (int) head.next.element) {
            return false;
        }

        // Recursive check on remaining list
        return isSorted(head.next);
    }
}
