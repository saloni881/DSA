import java.util.*;

public class RemoveDuplicates {

    // 1️ Brute Force (Using Set)

    // TC: O(n)
    // SC: O(n)

    public static int removeDuplicatesBrute(int[] nums) {

        Set<Integer> set = new LinkedHashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int index = 0;
        for (int num : set) {
            nums[index++] = num;
        }

        return set.size();
    }

    // 2️ Two Pointer Approach (Optimal )

    // TC: O(n)
    // SC: O(1)

    public static int removeDuplicatesOptimal(int[] nums) {

        if (nums.length == 0)
            return 0;

        int left = 0;

        for (int right = 1; right < nums.length; right++) {

            if (nums[right] != nums[left]) {
                left++;
                nums[left] = nums[right];
            }
        }

        return left + 1;
    }

    // MAIN METHOD

    public static void main(String[] args) {

        int[] nums1 = { 1, 1, 2 };
        int[] nums2 = { 1, 1, 2 };

        System.out.println("Brute Force:");
        int k1 = removeDuplicatesBrute(nums1);
        System.out.println("Count: " + k1);
        System.out.println("Array: " + Arrays.toString(nums1));

        System.out.println("Optimal (Two Pointer):");
        int k2 = removeDuplicatesOptimal(nums2);
        System.out.println("Count: " + k2);
        System.out.println("Array: " + Arrays.toString(nums2));
    }
}