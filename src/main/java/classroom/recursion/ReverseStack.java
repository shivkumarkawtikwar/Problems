package classroom.recursion;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);


        reverseStack(stack);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;

        int v = stack.pop();
        reverseStack(stack);

        insert(stack, v);
    }

    private static void insert(Stack<Integer> stack, int v) {

        if (stack.isEmpty()) {
            stack.push(v);
            return;
        }

        int x = stack.pop();
        insert(stack, v);
        stack.push(x);
    }
}
