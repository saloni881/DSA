import java.util.*;

public class MaximumSubarray {

    // 1️ Brute Force Approach
    // TC: O(n^2)

    public static int maxSubArrayBrute(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;

            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    // 2️ Kadane's Algorithm (Optimal)
    // TC: O(n)
    // SC: O(1)
    public static int maxSubArrayKadane(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {

            currentSum += nums[i];

            maxSum = Math.max(maxSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    // 3 Kadane with Subarray Printing
    public static int[] maxSubArrayWithIndices(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        int start = 0, end = 0, tempStart = 0;

        for (int i = 0; i < nums.length; i++) {

            currentSum += nums[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        return new int[] { maxSum, start, end };
    }

    // MAIN METHOD
    public static void main(String[] args) {

        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        System.out.println("Brute Force:");
        System.out.println(maxSubArrayBrute(nums));

        System.out.println("Kadane (Optimal):");
        System.out.println(maxSubArrayKadane(nums));

        System.out.println("Kadane with Indices (Sum, Start, End):");
        System.out.println(Arrays.toString(maxSubArrayWithIndices(nums)));
    }
}