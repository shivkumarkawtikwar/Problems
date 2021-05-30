package classroom.array;

/**
 * Sort Colors
 * Medium
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * Example 3:
 *
 * Input: nums = [0]
 * Output: [0]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 */
public class SortColors {

    public static void main(String[] args) {
        SortColors sc = new SortColors();

        int[] nums = {2,0,2,1,1,0}; //Output: [0,0,1,1,2,2]
        int[] res = sc.solve(nums);
        for (int r : res) {
            System.out.print(r+" ");
        }
        System.out.println(" ");

        int[] nums1 = {2,0,1}; //Output: [0,1,2]
        int[] res1 = sc.solve(nums1);
        for (int r : res1) {
            System.out.print(r+" ");
        }
        System.out.println(" ");

        int[] nums2 = {1}; //Output: [1]
        int[] res2 = sc.solve(nums2);
        for (int r : res2) {
            System.out.print(r+" ");
        }
        System.out.println(" ");
    }

    private int[] solve(int[] nums) {

        int z =0, s=nums.length-1;

        for (int i=0; i<nums.length; i++) {
            while (nums[i] == 2 && i < s) swap(nums, i, s--);
            while (nums[i] == 0 && i > z) swap(nums, i, z++);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int s) {
        int t = nums[s];
        nums[s] = nums[i];
        nums[i] = t;
    }

}
