package sortings;

public class SelectionSort {

    public static void main(String[] args) {

        int[] vals = {5, 1, 2, 3, 4};
        sort(vals);
    }

    private static void sort(int[] vals) {
        for(int i=0; i< vals.length; i++) {

            //select lowest index
            int lowIndex = i;
            for (int j = i+1; j < vals.length; j++) {
                if (vals[lowIndex] > vals[j])
                    lowIndex = j;
            }

            //swap first element with lowest index
            int temp = vals[lowIndex];
            vals[lowIndex] = vals[i];
            vals[i] = temp;
        }

        System.out.println("Sorted -> ");
        print(vals);
    }

    private static void print(int[] vals) {
        for (int val : vals) {
            System.out.print(val +" ");
        }
    }
}
