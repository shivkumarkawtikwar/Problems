package classroom.array;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

// Left - Right 1 based index os sub-array with max sum
public class KadaneAlgorithm {

    public static void main(String[] args) {

        KadaneAlgorithm ka = new KadaneAlgorithm();

        int[] num1 = {-2,1,-3,4,-1,2,1,-5,4};
        List<Integer> ans1 = ka.find(num1);
        Assert.assertEquals(4, (int)ans1.get(0));
        Assert.assertEquals(7, (int)ans1.get(1));


        int[] num2 = {-2,-1,-3,-4,-1,-2,-1,-5,-4};
        List<Integer> ans2 = ka.find(num2);
        Assert.assertEquals(2, (int)ans2.get(0));
        Assert.assertEquals(2, (int)ans2.get(1));

        int[] num3 = { -2, -1, 3, 4, -1, 2, -1, -5, 100};
        List<Integer> ans3 = ka.find(num3);
        Assert.assertEquals(3, (int)ans3.get(0));
        Assert.assertEquals(9, (int)ans3.get(1));
    }

    /**
     * Consider previous sum if it is adding any extra value to current value
     *
     * @param num
     * @return
     */
    private List<Integer> find(int[] num) {
        int sum  = num[0];
        int lm   = 0;
        int rm   = 0;
        int l    = 0;
        int max  = sum;

        for (int i=1; i<num.length; i++) {
            //add to sum if adding any extra value
            if(sum >= 0)
                sum = sum + num[i];
            else { // or just initialize sum to current value
                sum = num[i];
                l = i;
            }

            if (max < sum) {
                max = sum;
                lm = l;
                rm = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(lm+1);
        ans.add(rm+1);
        return ans;
    }
}
