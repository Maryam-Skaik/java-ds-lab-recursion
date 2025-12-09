package recursion;

/**
 * Recursion class demonstrates various recursive methods.
 * Examples include:
 * 1. Printing a name multiple times
 * 2. Printing arrays forward and backward
 * 3. Finding the maximum element in an array
 * 4. Calculating factorial
 * 5. Calculating Fibonacci numbers
 * 
 * Each method includes clear comments explaining recursion steps.
 * Author: Maryam
 */
public class Recursion {

    /**
     * Prints "Maryam" multiple times using recursion.
     * Base case: count == 0 stops recursion.
     * Recursive call: count decreases by 1 each time.
     */
    public static void printName(int count){
        if(count == 0) return;  // base case
        System.out.println("Maryam"); 
        printName(count - 1);    // recursive call
    }

    /**
     * Prints elements of an array in reverse order using recursion.
     * Base case: i reaches array length.
     * Recursive call first, then prints element to reverse.
     */
    public static void printArray(int arr[], int i){
        if(i == arr.length) return; // base case
        printArray(arr, i + 1);     // recursive call
        System.out.print(arr[i] + " "); // prints after recursion for reverse
    }

    /**
     * Finds the maximum value in an array recursively.
     * Base case: last index returns that element.
     * Recursive call compares current element with max of rest.
     */
    public static int findMax(int arr[], int i){
        if(i == arr.length - 1) return arr[i]; // base case
        int max = findMax(arr, i + 1);        // recursive call
        return Math.max(max, arr[i]);         // compare
    }

    /**
     * Computes factorial of n using recursion.
     * Base case: factorial of 0 or 1 is 1.
     * Recursive call multiplies n by factorial of n-1.
     */
    public static int factorial(int n){
        if(n == 0 || n == 1) return 1; 
        return n * factorial(n - 1); // recursive step
    }

    /**
     * Computes the nth Fibonacci number recursively.
     * Base cases: fib(0) = 0, fib(1) = 1.
     * Recursive call: sum of previous two Fibonacci numbers.
     */
    public static int fib(int n){
        if(n == 0 || n == 1) return n; 
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int arr[] = {-1, -20, -3, -4};
        
        // Examples to run:
        printName(5);
        printArray(arr, 0);
        System.out.println(findMax(arr, 0));
        System.out.println(factorial(5));
        System.out.println(fib(5));
    }
}
