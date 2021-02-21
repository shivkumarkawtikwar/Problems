package sortings;

//devide n conquer
public class MergeSort {

    public static void main(String[] args) {
        int[] v = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(v, 0, 6);
        print(v);
    }

    private static void mergeSort(int[] v, int l, int r) {
        if (l >= r)
            return;
        int m = l+((r-l) / 2);
        //break array into half
        mergeSort(v, l, m);
        mergeSort(v, m+1, r);

        //merge two sorted array
        merge(v, l, m, r);
    }

    private static void merge(int[] v, int l, int m, int r) {
        int ls = m - l + 1;
        int rs = r - m;
        int[] lA = new int[ls];
        int[] rA = new int[rs];

        for (int i=0; i<ls; i++)
            lA[i] = v[l+i];

        for (int i=0; i<rs; i++)
            rA[i] = v[m+i+1];

        int i=0, j=0;
        for (; i<ls && j < rs; ) {
            if (lA[i] < rA[j]) {
                v[l++] = lA[i];
                i++;
            }
            else {
                v[l++] = rA[j];
                j++;
            }
        }
        for (;i<ls; i++)
            v[l++] = lA[i];

        for (; j<rs; j++)
            v[l++] = rA[j];

    }

    private static void print(int[] vals) {
        for (int val : vals) {
            System.out.print(val +" ");
        }
    }
}
