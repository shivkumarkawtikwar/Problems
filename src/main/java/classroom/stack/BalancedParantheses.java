package classroom.stack;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class BalancedParantheses {

    public static void main(String[] args) {
        BalancedParantheses b = new BalancedParantheses();

        assertEquals(1, b.solve("()"));
        assertEquals(1, b.solve("(()())"));
        assertEquals(1, b.solve("()()()"));
        assertEquals(1, b.solve("()(())"));


        assertEquals(0, b.solve(")"));
        assertEquals(0, b.solve("(()()"));
        assertEquals(0, b.solve("())("));
        assertEquals(0, b.solve("()())"));
    }
    public int solve(String A) {

        Stack<Character> stack = new Stack<>();

        int i=0;
        while(i<A.length()) {
            char c = A.charAt(i);
            if(c == '(')
                stack.push(c);
            else {
                if(stack.isEmpty())
                    return 0;
                else
                    stack.pop();
            }
            i++;
        }

        return stack.isEmpty() ? 1 : 0;

    }

}
