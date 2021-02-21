package sortings;

public class BubbleSort {

    public static void main(String[] args) {
        int[] vals = {5, 1, 2, 3, 4};
        sort(vals);
    }

    //bubble max number to the end of array
    private static void sort(int[] v) {
        for (int i=0; i < v.length; i++) {
            for (int j = 0; j < v.length-i-1; j++) {
                if (v[j] > v[j+1]) {
                    int temp = v[j];
                    v[j] = v[j+1];
                    v[j+1] = temp;
                }
            }
        }
        print(v);
    }

    private static void print(int[] vals) {
        for (int val : vals) {
            System.out.print(val +" ");
        }
    }
}
