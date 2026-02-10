import java.util.*;

public class TwoSum {
    // 1️⃣ Brute Force Approach
    // TC: O(n^2)
    public static int[] twoSumBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    // 2️⃣ HashMap Approach (Optimal)
    // TC: O(n)
    public static int[] twoSumHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    // 3️⃣ Two Pointer Approach (Sorted Array Only)
    // TC: O(n)
    public static int[] twoSumTwoPointer(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[] { left, right };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] { -1, -1 };
    }

    // MAIN METHOD
    public static void main(String[] args) {

        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        System.out.println("Brute Force:");
        System.out.println(Arrays.toString(twoSumBrute(nums, target)));

        System.out.println("HashMap (Optimal):");
        System.out.println(Arrays.toString(twoSumHashMap(nums, target)));

        // For Two Pointer, array must be sorted
        int[] sortedNums = { 2, 7, 11, 15 };
        System.out.println("Two Pointer (Sorted Array):");
        System.out.println(Arrays.toString(twoSumTwoPointer(sortedNums, target)));
    }
}