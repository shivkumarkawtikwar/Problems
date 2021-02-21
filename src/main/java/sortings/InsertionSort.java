package sortings;

public class InsertionSort {

    public static void main(String[] args) {
        int[] vals = {5, 1, 2, 3, 4};
        sort(vals);
    }

    private static void sort(int[] v) {
        for (int i=1; i < v.length; i++) {
            int k = v[i];
            int j = i-1;
            while (j >= 0 && v[j] > k) {
                v[j + 1] = v[j];
                j = j-1;
            }
            //insert the key element at appropriate location
            v[j+1] = k;
        }
        print(v);
    }

    private static void print(int[] vals) {
        for (int val : vals) {
            System.out.print(val +" ");
        }
    }


}
