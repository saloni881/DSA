import java.util.*;

// The Stock Span problem calculates how many consecutive days
// the stock price was less than or equal to today's price.
// It is a classic Monotonic Stack problem.

public class StockSpan {

    
    // Approach 1: Brute Force
    
    // For each day, go backwards and count
    // tc: O(n^2)
    // sc: O(n) for result array

    public static int[] bruteForce(int[] prices) {

        int n = prices.length;
        int[] span = new int[n];

        for (int i = 0; i < n; i++) {

            span[i] = 1; // at least 1 (itself)

            int j = i - 1;

            while (j >= 0 && prices[j] <= prices[i]) {
                span[i]++;
                j--;
            }
        }

        return span;
    }


    
    // Approach 2: Stack (Optimal)
    
    // Use Monotonic Decreasing Stack
    // Store indices
    // tc: O(n)
    // sc: O(n)

    public static int[] optimalStack(int[] prices) {

        int n = prices.length;
        int[] span = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && prices[st.peek()] <= prices[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - st.peek();
            }

            st.push(i);
        }

        return span;
    }


    
    // Main Method
    

    public static void main(String[] args) {

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        System.out.println("Brute Force:");
        System.out.println(Arrays.toString(bruteForce(prices)));

        System.out.println("Optimal Stack:");
        System.out.println(Arrays.toString(optimalStack(prices)));
    }
}