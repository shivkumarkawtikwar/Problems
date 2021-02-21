package sortings;

public class QuickSort {

    public static void main(String[] args) {
        int[] v = {38, 27, 43, 3, 9, 82, 10};
        quickSort(v, 0, 6);
        print(v);
    }

    private static void print(int[] vals) {
        for (int val : vals) {
            System.out.print(val +" ");
        }
    }

    private static void quickSort(int[] v, int l, int r) {
        if (l>=r)
            return;
        int pivotIndex = partition(v, l, r);
        quickSort(v, l, pivotIndex-1);
        quickSort(v, pivotIndex+1, r);
    }

    private static int partition(int[] v, int l, int r) {
        int pivot = v[r];
        int i = l-1;

        for (int j=l; j<r; j++) {
            if (v[j] < pivot) {
                i++;
                int temp = v[j];
                v[j] = v[i];
                v[i] = temp;
            }
        }
        v[r] = v[i + 1];
        v[i + 1] = pivot;
        return i+1;
    }

}
