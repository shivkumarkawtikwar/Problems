package sortings;

public class HeapSort {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 3, 2 , 4, 1};
        heapSort( arr);

        for (int val : arr)
            System.out.print(val + " ");
    }

    private static void heapSort(int[] arr) {

        int n = arr.length-1;
        for(int i= (n/2); i>=0; i--)
            heapify(arr, n, i);


        for(int i=0; i<n; ) {
            int temp = arr[n];
            arr[n] = arr[0];
            arr[0] = temp;
            n= n-1;
            heapify(arr, n, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int l = 2*i + 1;
        int r = 2*i + 2;


        int largest = i;
        if(l <= n && arr[largest] < arr[l])
            largest = l;

        if(r <= n && arr[largest] < arr[r])
            largest = r;

        if(largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }
}
