package classroom.array;

import org.junit.Assert;

public class SortArrayWaveForm {

    public int[] sort(int[] array) {


        if (array.length <= 2)
            return array;

        boolean isIncreasing = array[1] > array[0];

        for (int i=2; i<array.length; i++) {
            if (isIncreasing && array[i-1] < array[i])
                swap(array, i-1, i);
            if(!isIncreasing && array[i-1] > array[i])
                swap(array, i-1, i);

            isIncreasing = !isIncreasing;
        }

        return array;
    }

    private void swap(int[] arr, int i, int j) {
        int t= arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        int arr[] = {10, 5, 6, 3, 2, 20, 100, 80};

        SortArrayWaveForm sawf = new SortArrayWaveForm();
        int[] res = sawf.sort(arr);
        validate(res);
    }

    private static void validate(int[] res) {

        if (res.length <= 2)
            return;

        for(int i=0; i<res.length; i++ ) {
            System.out.print(res[i] + " ");
        }

        boolean isIncreasing = res[1] > res[0];
        for(int i=2; i<res.length; i++ ) {
            Assert.assertTrue(isIncreasing ^ (res[i-1] < res[i]));
            isIncreasing = !isIncreasing;
        }
    }
}
