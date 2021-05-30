package classroom.stack;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ThreeStacksInArray {

    private int numberOfStacks;
    private int size;
    private List<Integer> list;
    private List<Integer> topList;

    public ThreeStacksInArray(int numberOfStacks, int size) {
        this.numberOfStacks = numberOfStacks;
        this.size = size;
        this.list = new ArrayList<>();
        for (int i=0; i<size*numberOfStacks; i++)
            this.list.add(0);
        this.topList = new ArrayList<>();
        for (int i=0; i<numberOfStacks; i++)
            this.topList.add(i*size);
    }

    public void push(int stackN, int v) {
        stackN = stackN -1;
        if(stackN >= numberOfStacks )
            return;

        int top = topList.get(stackN);
        if(top < (stackN+1)*size) {
            list.set(top, v);
            topList.set(stackN, top+1);
        }
    }

    public int pop(int stackN) {
        int v = -1;
        stackN = stackN -1;
        if(stackN >= numberOfStacks )
            return v;

        int top = topList.get(stackN);
        if(top > (stackN * size)) {
            top--;
            v = list.get(top);
            topList.set(stackN, top);
        }
        return v;
    }

    public static void main(String[] args) {

        ThreeStacksInArray t = new ThreeStacksInArray(3, 5);

        t.push(1, 1);
        t.push(1, 2);
        t.push(1, 3);
        t.push(1, 4);
        t.push(1, 5);
        t.push(1, 6);
        t.push(2, 1);
        t.push(3, 1);
        t.push(2, 2);
        t.push(3, 2);
        t.push(3, 3);

        assertEquals(3, t.pop(3));
        assertEquals(2, t.pop(2));
        assertEquals(1, t.pop(2));
        assertEquals(-1, t.pop(2));
        assertEquals(2, t.pop(3));
        assertEquals(5, t.pop(1));
        assertEquals(4, t.pop(1));
        assertEquals(3, t.pop(1));

        t.push(1, 3);
        t.push(1, 4);

        assertEquals(4, t.pop(1));
        assertEquals(3, t.pop(1));
    }
}
