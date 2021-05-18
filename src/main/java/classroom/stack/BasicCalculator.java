package classroom.stack;

import org.junit.Assert;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();

        Assert.assertEquals(3, calculator.calculate("1+2"));
        Assert.assertEquals(3, calculator.calculate("1+(1+1)"));
        Assert.assertEquals(7, calculator.calculate("(1+(2+(2+2)))"));
        Assert.assertEquals(-1, calculator.calculate("-3+2"));
        Assert.assertEquals(-1, calculator.calculate("1+(-3+1)"));

    }


    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ')
                continue;
            if(c == '-' || c == '+') {
                if(stack.isEmpty() || stack.peek().equals("("))
                    stack.push("0");
                stack.push(c + "");
            } else if( c == '(')
                stack.push(c+"");
            else if(c == ')') {
                int num = Integer.parseInt(stack.pop());
                stack.pop();
                insert(stack, num);
            } else {
                StringBuilder sb = new StringBuilder();
                while(c >= '0' && c <= '9') {
                    sb.append(c);
                    i++;
                    if(i>=s.length())
                        break;
                    c = s.charAt(i);
                }
                i--;
                insert(stack, Integer.parseInt(sb.toString()));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private void insert(Stack<String> stack, int num1) {
        if(stack.isEmpty() || stack.peek().equals("("))
            stack.push("" + num1);
        else {
            String op = stack.pop();
            int num2 = Integer.parseInt(stack.pop());
            int num = op.equals("+") ? (num2 + num1) : (num2 - num1);
            insert(stack, num);
        }
    }
}
