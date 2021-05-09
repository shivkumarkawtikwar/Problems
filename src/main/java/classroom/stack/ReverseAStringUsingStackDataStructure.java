package classroom.stack;

import java.util.Stack;

public class ReverseAStringUsingStackDataStructure {


    public static void main(String[] args) {
        ReverseAStringUsingStackDataStructure r = new ReverseAStringUsingStackDataStructure();

        String rev = r.reverse("abccdfegh");
        System.out.println(rev);
    }

    public String reverse(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());

        return sb.toString();
    }
}
