package classroom.array;

import static org.junit.Assert.assertEquals;

/**
 * Search in Rotated Sorted Array
 * Medium
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();

        int[] nums1 = {4,5,6,7,0,1,2};
        int ans = s.solve(nums1, 0);
        assertEquals(4, ans);

        int[] nums2 = {4,5,6,7,0,1,2};
        ans = s.solve(nums2, 3);
        assertEquals(-1, ans);

        int[] nums3 = {0,1,2,4,5,6,7};
        ans = s.solve(nums3, 4);
        assertEquals(3, ans);

        int[] nums4 = {3,1};
        ans = s.solve(nums4, 1);
        assertEquals(1, ans);
    }

    private int solve(int[] nums, int target) {

        int k = findPivot(nums);

        int r = search(nums, 0, k-1, target);
        if(r == -1)
            r = search(nums, k, nums.length-1, target);

        return r;
    }

    private int search(int[] nums, int i, int j, int target) {

        while(i <= j) {
            int m = (i+j)/2;
            if(nums[m] > target)
                j = m-1;
            else if (nums[m] < target){
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    private int findPivot(int[] nums) {
        int f = nums[0];
        int i = 1;
        int j = nums.length - 1;
        while(i <= j) {
            int m = (i+j)/2;
            if(nums[m] > f)
                i = m+1;
            else {
                if(m == 0 || nums[m-1] >= f)
                    return m;
                j = m - 1;
            }
        }
        return 0;
    }


}
