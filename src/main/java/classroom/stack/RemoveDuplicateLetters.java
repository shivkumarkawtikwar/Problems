package classroom.stack;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {

        char[] ca = s.toCharArray();
        int[] fr = new int[26];
        boolean[] visited = new boolean[26];

        for (char c : ca)
            fr[c - 'a']++;

        Stack<Character> stack = new Stack<>();

        for (char c : ca) {
            fr[c - 'a']--;

            if (visited[c - 'a'])
                continue;

            while (!stack.isEmpty() && stack.peek() > c && fr[stack.peek() - 'a'] != 0) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);

            visited[c - 'a'] = true;

        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.insert(0, stack.pop());

        return sb.toString();
    }

    public static void main(String[] args) {

        RemoveDuplicateLetters r = new RemoveDuplicateLetters();

        String s1 = "bcabc";
        assertEquals("abc", r.removeDuplicateLetters(s1));

        String s2 = "cbacdcbc";
        assertEquals("acdb", r.removeDuplicateLetters(s2));

    }
}
