package classroom.stack;

import java.util.Stack;

public class ValidateSequence {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4, 5, 3, 2, 1};
        System.out.println(validateSeq(a, b));
        int[] c = {1, 2, 3, 4, 5};
        int[] d = {4, 5, 3, 1, 2};
        System.out.println(validateSeq(c, d));

        int[] e = {1, 2, 3, 4, 5};
        int[] f = {4, 3, 5, 1, 2};
        System.out.println(validateSeq(e, f));

        int[] g = {1, 2, 3, 4, 5};
        int[] h = {1, 2, 3, 4, 5};
        System.out.println(validateSeq(g, h));

        int[] i = {1, 2, 3, 4, 5};
        int[] j = {5, 4, 3, 2, 1};
        System.out.println(validateSeq(i, j));
    }

    public static boolean validateSeq(int[] a, int[] b) {

        if(a.length != b.length)
            return false;

        int j=0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i < a.length; i++) {
            stack.push(a[i]);
            while (!stack.isEmpty() && stack.peek() == b[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
