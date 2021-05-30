package classroom.array;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Subarray Sum Equals K
 * Medium
 *
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 */
public class SubarraySumEqualsK {

    public static void main(String[] args) {
        SubarraySumEqualsK s = new SubarraySumEqualsK();

        int[] nums1 = {1,1,1};
        int ans = s.solve(nums1, 2);
        assertEquals(2, ans);

        int[] nums2 = {1,2,3};
        ans = s.solve(nums2, 3);
        assertEquals(2, ans);
    }

    public int solve(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int rs = 0;
        for (int i=0; i<nums.length; i++) {
            rs += nums[i];
            res += map.getOrDefault(rs - k, 0);
            int f = map.getOrDefault(rs, 0);
            map.put(rs, f + 1);
        }
        return res;
    }
}
