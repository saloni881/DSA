public class TrappingRainWater {

    // Brute Force
    // TC: O(n^2)
    // SC: O(1)

    public static int trapBrute(int[] height) {

        int n = height.length;
        int totalWater = 0;

        for (int i = 0; i < n; i++) {

            int leftMax = 0, rightMax = 0;

            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            totalWater += Math.min(leftMax, rightMax) - height[i];
        }

        return totalWater;
    }

    // 2️ Better Approach (Prefix & Suffix Arrays)

    // TC: O(n)
    // SC: O(n)

    public static int trapBetter(int[] height) {

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int totalWater = 0;

        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
    }

    // 3️ Optimal Two Pointer Approach

    // TC: O(n)
    // SC: O(1)

    public static int trapOptimal(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left <= right) {

            if (height[left] <= height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }

    // MAIN METHOD

    public static void main(String[] args) {

        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        System.out.println("Brute Force: " + trapBrute(height));

        System.out.println("Better (Prefix/Suffix): " + trapBetter(height));

        System.out.println("Optimal (Two Pointer): " + trapOptimal(height));
    }
}