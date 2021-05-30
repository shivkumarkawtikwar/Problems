package classroom.stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidateBrackets {

    private static HashMap<Character, Character> map = new HashMap<>();

    static {
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
    }

    public static void main(String[] args) {
        String s= "{()}[]";
        boolean isValid = validate(s);
        System.out.println("input: "+s);
        System.out.println("output: " +isValid);

        s = "{[]()[]}";
        isValid = validate(s);
        System.out.println("input: "+s);
        System.out.println("output: " +isValid);

        s = "[{[]()[]}]";
        isValid = validate(s);
        System.out.println("input: "+s);
        System.out.println("output: " +isValid);

        s = "[{[]()[]}]]";
        isValid = validate(s);
        System.out.println("input: "+s);
        System.out.println("output: " +isValid);

        s = ")(";
        isValid = validate(s);
        System.out.println("input: "+s);
        System.out.println("output: " +isValid);

        s = "(}";
        isValid = validate(s);
        System.out.println("input: "+s);
        System.out.println("output: " +isValid);
    }

    private static boolean validate(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                stack.push(map.get(c));
            else {
                if (stack.isEmpty() || stack.pop() != c)
                    return false;

            }
        }

        return stack.isEmpty();
    }
}
