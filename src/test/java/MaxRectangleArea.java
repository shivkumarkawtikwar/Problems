import org.junit.Assert;
import org.junit.Test;

public class MaxRectangleArea {

    @Test
    public void test() {

        char[][] matrix = new char[][]{{'1', '0', '0', '1', '1'},
                  {'1', '0', '1', '1', '1'},
                  {'1', '1', '1', '1', '1'},
                  {'1', '0', '1', '1', '1'}};

        MaximalRectangle maximalRectangle = new MaximalRectangle();
        int maxArea = maximalRectangle.maximalRectangle(matrix);
        System.out.println(maxArea);
        Assert.assertTrue(maxArea == 6);
    }

    @Test
    public void testNoOfOne() {

        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};


        int[][] no = new int[4][5];
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        maximalRectangle.initNoOfOne(matrix, 4, 5, no);

        int nr = matrix.length;
        int nc = matrix[0].length;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                System.out.print(no[i][j]);
            }
            System.out.println("");
        }
    }

}
