package classroom.stack;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> push, pop;

    /** Initialize your data structure here. */
    public QueueUsingStack() {
        push = new Stack<>();
        pop = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        push.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(pop.isEmpty()) {
            while(!push.isEmpty())
                pop.push(push.pop());
        }
        return pop.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(pop.isEmpty()) {
            while(!push.isEmpty())
                pop.push(push.pop());
        }
        return pop.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return push.isEmpty() && pop.isEmpty();
    }
}


