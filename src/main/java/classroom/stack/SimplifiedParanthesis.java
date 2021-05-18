package classroom.stack;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class SimplifiedParanthesis {


    public static void main(String[] args) {


        assertEquals("/home", simplifyPath("/home/"));
        assertEquals("/c", simplifyPath("/a/./b/../../c/"));

        //corner cases
        assertEquals("/a/b", simplifyPath("/a//b"));
        assertEquals("/", simplifyPath("/../.."));

    }

    public static String simplifyPath(String A) {
        Stack<String> stack = new Stack<>();
        int i=0;
        while( i<A.length()) {
            char c = A.charAt(i++);

            if(i>=A.length())
                break;

            StringBuilder folder = new StringBuilder();
            char c1 = A.charAt(i);
            while(c1 != '/' ) {
                folder.append(c1);
                i++;
                if(i>=A.length())
                    break;

                c1 = A.charAt(i);
            }
            if(folder.toString().equals(".")) {
                continue;
            } else if(folder.toString().equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
            } else {
                if(folder.toString().trim().length() > 0)
                    stack.push("/" + folder.toString());
            }
        }

        Stack<String> tempStack = new Stack<>();
        while(!stack.isEmpty())
            tempStack.push(stack.pop());

        StringBuilder path = new StringBuilder();
        if(tempStack.isEmpty())
            path.append("/");
        else {

            while(!tempStack.isEmpty())
                path.append(tempStack.pop());
        }

        return path.toString();
    }
}
