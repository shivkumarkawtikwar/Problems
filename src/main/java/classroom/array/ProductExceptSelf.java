package classroom.array;

public class ProductExceptSelf {

    public static void main(String[] args) {
        ProductExceptSelf pes = new ProductExceptSelf();

        int[] nums = {1,2,3,4}; //Output: [24,12,8,6]
        int[] res = pes.productExceptSelf(nums);
        for (int r : res) {
            System.out.print(r+" ");
        }
        System.out.println(" ");

        int[] nums1 = {-1,1,0,-3,3}; //Output: [0,0,9,0,0]
        int[] res1 = pes.productExceptSelf(nums1);
        for (int r : res1) {
            System.out.print(r+" ");
        }
        System.out.println(" ");
    }

    public int[] productExceptSelf(int[] nums) {

        int noOfZeroes = 0;
        int product =1;

        for(int i=0; i<nums.length; i++) {
            product *= nums[i] == 0 ? 1 : nums[i];
            noOfZeroes += nums[i] == 0 ? 1 : 0;
        }




        int[] res = new int[nums.length];
        if(noOfZeroes > 1)
            return res;

        for(int i=0; i<nums.length; i++) {
            if(noOfZeroes == 1) {
                if(nums[i] == 0)
                    res[i] = product;
                else
                    res[i] = 0;
            } else {
                res[i] = product/nums[i];
            }
        }

        return res;
    }
}
