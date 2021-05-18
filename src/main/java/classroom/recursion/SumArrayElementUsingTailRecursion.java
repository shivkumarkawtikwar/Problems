package classroom.recursion;

/**
 * The tail recursive functions considered better than non tail recursive functions as tail-recursion can be optimized by compiler.
 * The idea used by compilers to optimize tail-recursive functions is simple,
 * since the recursive call is the last statement, there is nothing left to do in the current function,
 * so saving the current function’s stack frame is of no use.
 */
public class SumArrayElementUsingTailRecursion {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 2, 3, 4, 6, 5};
        int sum = sumWithTailRecursion(arr, 0, 0);

        System.out.println("sumWithTailRecursion -> " + sum);

        sum = sumWithoutTailRecursion(arr, 0);
        System.out.println("sumWithoutTailRecursion -> " + sum);
    }

    public static int sumWithTailRecursion(int[] arr, int ind, int sum) {
        if(ind >= arr.length)
            return sum;

        //In tail recursion call to recursion method is the last thing
        return sumWithTailRecursion(arr, ind+1, arr[ind] + sum);
    }


    public static int sumWithoutTailRecursion(int[] arr, int ind) {
        if(ind >= arr.length)
            return 0;
        //In non-tail recursion call to recursion method is the not the last thing
        //return value is getting added, which is last thing
        return arr[ind] + sumWithoutTailRecursion(arr, ind+1);
    }
}
