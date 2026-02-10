import java.util.*;

public class MoveZeroes {
    // 1️ Brute Force (Extra Array)
    // TC: O(n)
    // SC: O(n)
    public static void moveZeroesBrute(int[] nums) {

        int[] temp = new int[nums.length];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp[index++] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    // 2️ Better Approach
    // TC: O(n)
    // SC: O(1)
    public static void moveZeroesBetter(int[] nums) {

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    // 3️ Optimal Approach (Single Pass Swap)

    // TC: O(n)
    // SC: O(1)

    public static void moveZeroesOptimal(int[] nums) {

        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] != 0) {

                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
            }
        }
    }

    // MAIN METHOD

    public static void main(String[] args) {

        int[] nums1 = { 0, 1, 0, 3, 12 };
        int[] nums2 = { 0, 1, 0, 3, 12 };
        int[] nums3 = { 0, 1, 0, 3, 12 };

        moveZeroesBrute(nums1);
        System.out.println("Brute: " + Arrays.toString(nums1));

        moveZeroesBetter(nums2);
        System.out.println("Better: " + Arrays.toString(nums2));

        moveZeroesOptimal(nums3);
        System.out.println("Optimal: " + Arrays.toString(nums3));
    }
}