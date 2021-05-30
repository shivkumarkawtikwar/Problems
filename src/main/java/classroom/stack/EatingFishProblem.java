package classroom.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class EatingFishProblem {

    public static void main(String[] args) {

        int[] arr1 = {10, 11,  8,  5,  3,   4,   6,   9,    2,    1 ,   8} ;
        int[] dir1 = {-1, -1,  1,  1,  1,  -1,  -1,  -1,   -1,   -1 ,   1} ;
        List<Integer> res1 = solve(arr1,dir1);
        assertEquals(6, res1.size());
        assertEquals(10, (int) res1.get(0));
        assertEquals(11, (int) res1.get(0));
        assertEquals(9, (int) res1.get(0));
        assertEquals(2, (int) res1.get(0));
        assertEquals(1, (int) res1.get(0));
        assertEquals(8, (int) res1.get(0));


        int[] arr2 = {10, 11,  12,  13,  3,   4,   6,   9,    2,    1 ,   8} ;
        int[] dir2 = {-1, -1,  1,  1,  1,  -1,  -1,  -1,   -1,   -1 ,   1} ;
        List<Integer> res2 = solve(arr2,dir2);
        assertEquals(5, res2.size());
        assertEquals(10, (int) res2.get(0));
        assertEquals(11, (int) res2.get(0));
        assertEquals(12, (int) res2.get(0));
        assertEquals(13, (int) res2.get(0));
        assertEquals(8, (int) res2.get(0));
    }

    private static List<Integer> solve(int[] size, int[] dir) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<size.length; i++) {
            if(dir[i] == 1)
                stack.push(size[i]);
            else {
                while (!stack.isEmpty() && stack.peek() < size[i])
                    stack.pop();
                if (stack.isEmpty())
                    res.add(dir[i]);
            }
        }
        int ind = res.size();
        while (!stack.isEmpty())
            res.add( ind, stack.pop());



        return res;
    }


}
