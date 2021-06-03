package classroom.array;

import org.junit.Assert;

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {

        int t = 0;
        for(int i=0; i<nums.length; i++)
            t += nums[i];

        int rs=0;
        for(int i=0; i<nums.length; i++) {
            if(rs == (t-rs-nums[i]))
                return i;
            rs = rs + nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {

        FindPivotIndex fpi = new FindPivotIndex();

        int[] nums1 = {1,7,3,6,5,6};
        int pivot1 = fpi.pivotIndex(nums1);
        Assert.assertEquals(3, pivot1);

        int[] nums2 = {1,2,3};
        int pivot2 = fpi.pivotIndex(nums2);
        Assert.assertEquals(-1, pivot2);

        int[] nums3 = {2,1,-1};
        int pivot3 = fpi.pivotIndex(nums3);
        Assert.assertEquals(0, pivot3);

    }

}
