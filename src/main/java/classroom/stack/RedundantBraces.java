package classroom.stack;

import org.junit.Assert;

import java.util.Stack;

public class RedundantBraces {

    public static void main(String[] args) {

        Assert.assertEquals(1, braces("()"));
        Assert.assertEquals(1, braces("(a)"));
        Assert.assertEquals(0, braces("(a+b)"));
        Assert.assertEquals(0, braces("(a+(b+c))"));
        Assert.assertEquals(0, braces("((a+b)+c)"));

    }


    public static int braces(String A) {

        int prevOpen = -1;
        int prevClose =-1;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<A.length(); i++) {
            char c = A.charAt(i);
            if(c == '(')
                stack.push(i);
            else if(c == ')') {
                int openAt = stack.pop();
                int closeAt = i;
                if(openAt == (closeAt-1) || (openAt+1) == (closeAt-1))
                    return 1;

                if(prevOpen != -1) {
                    if( (prevClose+1) == closeAt && (openAt+1) == prevOpen)
                        return 1;
                }

                prevOpen  = openAt;
                prevClose = closeAt;
            }

        }

        return 0;

    }

}
