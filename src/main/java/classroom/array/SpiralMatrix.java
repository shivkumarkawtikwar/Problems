package classroom.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {


        List<Integer> res = new ArrayList<>();

        int l=0, r=matrix[0].length-1;
        int t=0, b=matrix.length-1;
        while(true) {

            for(int i=l; i<=r; i++)
                res.add(matrix[t][i]);
            t++;
            if(res.size() == (matrix[0].length*matrix.length))
                break;

            for(int i=t; i<=b; i++)
                res.add(matrix[i][r]);
            r--;
            if(res.size() == (matrix[0].length*matrix.length))
                break;

            for(int i=r; i>=l; i--)
                res.add(matrix[b][i]);
            b--;
            if(res.size() == (matrix[0].length*matrix.length))
                break;

            for(int i=b; i>=t; i--)
                res.add(matrix[i][l]);
            l++;

            if(res.size() == (matrix[0].length*matrix.length))
                break;

        }

        return res;
    }
}
