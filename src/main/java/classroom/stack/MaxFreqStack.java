package classroom.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MaxFreqStack {

    private Map<Integer, Integer> freq = new HashMap<>();
    private Map<Integer, List<Integer>> freqElements = new HashMap<>();
    private int maxFreq=0;

    public void pushItem(int v) {
        int f = freq.getOrDefault(v, 0) + 1;
        if(maxFreq < f)
            maxFreq = f;
        freq.put(v, f);
        List<Integer> list = freqElements.getOrDefault(f, new ArrayList<>());
        list.add(v);
        freqElements.put(f, list);
    }

    public int popItem() {
        List<Integer> list = freqElements.get(maxFreq);
        int v = list.remove(list.size()-1);
        int f  = freq.get(v) - 1;
        if (f == 0)
            freq.remove(v);
        else
            freq.put(v, f);
        if (list.size() == 0)
            maxFreq = maxFreq-1;

        return v;
    }


    public static void main(String[] args) {
        MaxFreqStack obj = new MaxFreqStack();

        obj.pushItem(5);
        obj.pushItem(7);
        obj.pushItem(5);
        obj.pushItem(7);
        obj.pushItem(4);
        obj.pushItem(5);

        assertEquals(5, obj.popItem());
        assertEquals(7, obj.popItem());
        assertEquals(5, obj.popItem());
        assertEquals(4, obj.popItem());
        assertEquals(7, obj.popItem());
        assertEquals(5, obj.popItem());
    }
}
