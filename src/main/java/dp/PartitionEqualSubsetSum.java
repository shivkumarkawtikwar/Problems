package dp;

/**
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class PartitionEqualSubsetSum {


    public static void main(String[] args) {
        //int[] nums = {1,5,11,5};
        //int[] nums = {9,1,2,4,10};
        int[] nums = {4,4,4,4,4,4,4,4,8,8,8,8,8,8,8,8,12,12,12,12,12,12,12,12,16,16,16,16,16,16,16,16,20,20,20,20,20,20,20,20,24,24,24,24,24,24,24,24,28,28,28,28,28,28,28,28,32,32,32,32,32,32,32,32,36,36,36,36,36,36,36,36,40,40,40,40,40,40,40,40,44,44,44,44,44,44,44,44,48,48,48,48,48,48,48,48,52,52,52,52,52,52,52,52,56,56,56,56,56,56,56,56,60,60,60,60,60,60,60,60,64,64,64,64,64,64,64,64,68,68,68,68,68,68,68,68,72,72,72,72,72,72,72,72,76,76,76,76,76,76,76,76,80,80,80,80,80,80,80,80,84,84,84,84,84,84,84,84,88,88,88,88,88,88,88,88,92,92,92,92,92,92,92,92,96,96,96,96,96,96,96,96,97,99};
        long start = System.currentTimeMillis();
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();
        System.out.println(solution.canPartition(nums));
        long end = System.currentTimeMillis();
        System.out.println((double) (end - start) / 1000);
    }


    int[][] lookUp;

    public boolean canPartition(int[] nums) {


        int s1 =0;
        int n = nums.length;

        for (int i=0; i < n; i++)
            s1 += nums[i];


        lookUp = new int[n+1][s1+1];

        for (int i =0; i<= n; i++) {
            for (int j =0; j<= s1; j++) {
                lookUp[i][j] = -1;
            }
        }

        boolean canParttion = (s1 % 2 == 0) && canPartitionIterative(nums, n, s1, s1 / 2);
        return canParttion;
    }

    /**
     * Recursive DP
     * @param nums
     * @param n
     * @param s1
     * @param half
     * @return
     */
    private boolean canPartition(int[] nums, int n, int s1, int half) {
        if (n == 0 || s1 == 0)
            return false;

        if (lookUp[n][s1] != -1)
            return lookUp[n][s1] == 1;

        boolean result = s1 == half || canPartition(nums, n - 1, s1 - nums[n - 1], half) ||
                    canPartition(nums, n - 1, s1, half);

        lookUp[n][s1] = result ? 1 : 0;
        return result;
    }


    /**
     * Iterative DP
     * @param nums
     * @param n
     * @param s
     * @param half
     * @return
     */
    private boolean canPartitionIterative(int nums[], int n, int s, int half) {

        boolean[][] t = new boolean[n+1][half+1];
        for (int i=0; i <= n; i++) {
            for (int j=0; j <= half; j++ ) {
                if (i == 0)
                    t[i][j] = false;
                if (j ==0)
                    t[i][j] = true;
            }
        }

        for (int i=1; i <= n; i++) {
            for (int j=1; j <= half; j++ ) {
                if (j >= nums[i-1]) {
                    t[i][j] = t[i - 1][j - nums[i - 1]] || t[i - 1][j];
                }
                else
                    t[i][j] = false;
            }
        }
        return t[n][half];
    }
}