package datastructures.patterns.twopointers;

/**
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * The max area in the above example is going to be 49 as height is 7 and width will be 7
 *
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.print(maxArea(height));
    }

    /**
     *
     *
     * Time complexity: O(n). Single pass.
     * Space complexity: O(1). Constant space is used.
     */
    public static int maxArea(int[] height) {
        int start = 0, end = height.length-1;
        int maxArea = 0;

        while (start < end) {
            int h = Math.min(height[start], height[end]);
            int w = end - start;

            maxArea = Math.max(maxArea, h*w);

            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }

//    public int maxArea(int[] height) {
//        int maxArea = 0;
//        for (int i = 0; i < height.length-1; i++) {
//            for (int j = i+1; j < height.length; j++) {
//                int h = height[i] < height[j] ? height[i] : height[j];
//                int w = j-i;
//                int area = h*w;
//
//                if (maxArea < area) {
//                    maxArea = area;
//                }
//            }
//        }
//        return maxArea;
//    }
}
