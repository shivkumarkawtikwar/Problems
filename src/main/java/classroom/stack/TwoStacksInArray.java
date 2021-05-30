package classroom.stack;

import static org.junit.Assert.assertEquals;

public class TwoStacksInArray {

    int top1 = 0;
    int top2 = 9;
    private int[] array = new int[10];

    public void push(int stackNumber, int val) {
        if (stackNumber == 1)
            pushToStack1(val);
        else if (stackNumber == 2)
            pushToStack2(val);
    }

    public int pop(int stackNumber) {
        int val = -1;
        if (stackNumber == 1)
            val = popFromStack1();
        else if (stackNumber == 2)
            val = popFromStack2();
        return val;
    }

    private int popFromStack1() {
        if (top1>0) {
            top1--;
            return array[top1];
        }
        return -1;
    }

    private int popFromStack2() {
        if (top2 < array.length-1) {
            top2++;
            return array[top2];
        }
        return -1;
    }

    private void pushToStack1(int val) {
        if (top1 <= top2)
            array[top1++] = val;
    }

    private void pushToStack2(int val) {
        if (top1 <= top2)
            array[top2--] = val;
    }


    public static void main(String[] args) {

        TwoStacksInArray stacksInArray = new TwoStacksInArray();
        stacksInArray.push(1,1);
        stacksInArray.push(2,2);
        stacksInArray.push(1,3);
        stacksInArray.push(2,4);
        stacksInArray.push(1,5);


        assertEquals(stacksInArray.pop(1), 5);
        assertEquals(stacksInArray.pop(2), 4);

        stacksInArray.push(2,7);
        stacksInArray.push(1,8);

        assertEquals(stacksInArray.pop(1), 8);
        assertEquals(stacksInArray.pop(2), 7);

        assertEquals(stacksInArray.pop(1), 3);
        assertEquals(stacksInArray.pop(1), 1);
        assertEquals(stacksInArray.pop(2), 2);
    }
}