package classroom.recursion;

import java.util.ArrayList;
import java.util.List;

public class TraverseMatrixWithRecursion {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        int[][] matrix = {{1 ,2 ,3},{4 ,5 ,6},{7 ,8 ,9}};

        traverse(matrix, list, 0, 0);

        for (int i : list)
            System.out.println(i);
    }

    public static void traverse(int[][] matrix, List<Integer> list, int i, int j) {
        if(j >= matrix[0].length  ) {
            i = i + 1;
            j = 0;
        }
        if(i >= matrix.length)
            return;

        list.add(matrix[i][j]);

        traverse(matrix, list, i, j+1);
    }
}
