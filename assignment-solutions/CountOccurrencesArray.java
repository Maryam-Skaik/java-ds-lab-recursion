package recursion.assignment_solutions;

/**
 * Problem:
 * Count how many times a given value appears in an array using recursion.
 *
 * Example:
 * arr = [1, 2, 3, 2, 2], target = 2
 * Output = 3
 *
 * Approach:
 * - Process one element at a time
 * - If current element matches target, count it
 * - Move to the next index recursively
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) due to recursion stack
 */
public class CountOccurrencesArray {

    public static int countOccurrence(int[] arr, int target, int index) {

        // Base case: reached end of array
        if (index == arr.length) {
            return 0;
        }

        // Count current match (if any)
        int count = (arr[index] == target) ? 1 : 0;

        // Recursive call for the rest of the array
        return count + countOccurrence(arr, target, index + 1);
    }
}
