package classroom.array;

import static org.junit.Assert.assertEquals;

public class NextSmallestPermutation {

    public String findSmallestPermutation(String s) {

        int[] f = new int[10];
        for (int i=0; i<s.length(); i++)
            f[s.charAt(i)-'0']++;

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<10; i++) {
            while (f[i] > 0) {
                sb.append(i);
                f[i]--;
            }
        }
        while (f[0] > 0) {
            sb.insert(1, '0');
            f[0]--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        NextSmallestPermutation p = new NextSmallestPermutation();
        assertEquals("100", p.findSmallestPermutation("100"));
        assertEquals("1001", p.findSmallestPermutation("1100"));
        assertEquals("1008", p.findSmallestPermutation("8001"));
        assertEquals("12345", p.findSmallestPermutation("54213"));
        assertEquals("1002345", p.findSmallestPermutation("5402013"));
        assertEquals("1004568", p.findSmallestPermutation("5468001"));
    }
}
