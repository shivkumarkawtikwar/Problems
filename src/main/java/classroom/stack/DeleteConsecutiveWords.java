package classroom.stack;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DeleteConsecutiveWords {

    public static void main(String[] args) {
        DeleteConsecutiveWords d = new DeleteConsecutiveWords();

        List<String> list = new ArrayList<>(Arrays.asList("ab", "aa", "aa", "bcd", "ab"));
        int r = d.deleteConsecutiveWords(list);
        Assert.assertEquals(3, r);

        list = new ArrayList<>(Arrays.asList("tom", "jerry", "jerry", "tom"));
        r = d.deleteConsecutiveWords(list);
        Assert.assertEquals(0, r);

    }

    public int deleteConsecutiveWords(List<String> list) {

        Stack<String> stack = new Stack<>();
        for (int i=0; i<list.size(); i++) {
            String item = list.get(i);
            if (!stack.isEmpty() && stack.peek().equals(item))
                stack.pop();
            else
                stack.push(item);
        }

        return stack.size();
    }

}
