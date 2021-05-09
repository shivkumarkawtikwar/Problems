package classroom.recursion;

import java.util.Stack;

public class SortStack {


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(4);


        sortStack(stack);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void sortStack(Stack<Integer> stack){
        if (stack.isEmpty())
            return;

        int v = stack.pop();
        sortStack(stack);

        insert(stack, v);
    }

    private static void insert(Stack<Integer> stack, int v) {

        if (stack.isEmpty()) {
            stack.push(v);
            return;
        }

        if(v < stack.peek()) {
            stack.push(v);
            return;
        }

        int x = stack.pop();
        insert(stack, v);
        stack.push(x);
    }
}
