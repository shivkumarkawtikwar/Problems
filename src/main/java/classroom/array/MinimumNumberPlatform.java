package classroom.array;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MinimumNumberPlatform {

    private int findPlatform(int[] arr, int[] dep) {

        Node[] nodes = new Node[arr.length*2];

        for (int i =0; i<arr.length; i++)
            nodes[i] = new Node(arr[i], 0);

        for (int i =0; i<arr.length; i++)
            nodes[arr.length + i] = new Node(dep[i], 1);

        Arrays.sort(nodes);

        int max = 0;
        int curr = 0;
        for (int i=0; i<nodes.length; i++) {
            if (nodes[i].isA == 0)
                curr++;
            else
                curr--;

            if (max < curr)
                max = curr;
        }

        return max;
    }

    public static void main(String[] args) {
        MinimumNumberPlatform mnp = new MinimumNumberPlatform();

        int arr1[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep1[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int mn1 = mnp.findPlatform(arr1, dep1);
        assertEquals(3, mn1);


        int arr2[] = { 900, 920, 940, 1100, 1500, 1910 };
        int dep2[] = { 910, 930, 950, 1130, 1900, 2000 };
        int mn2 = mnp.findPlatform(arr2, dep2);
        assertEquals(1, mn2);


        int arr3[] = { 900, 920, 940, 1100, 1500, 1910 };
        int dep3[] = { 2100, 930, 950, 1130, 1900, 2000 };
        int mn3 = mnp.findPlatform(arr3, dep3);
        assertEquals(2, mn3);

        int arr4[] = { 900, 920, 940, 1100, 1500, 1910 };
        int dep4[] = { 2100, 1930, 950, 1130, 1900, 2000 };
        int mn4 = mnp.findPlatform(arr4, dep4);
        assertEquals(3, mn4);
    }

    private static class Node implements Comparable<Node> {
        int t;
        int isA;

        public Node(int t, int isA) {
            this.t = t;
            this.isA = isA;
        }

        @Override
        public int compareTo(Node o) {
            int d = t - o.t;
            if (d == 0)
                d = isA - o.isA;
            return d;
        }
    }

}
