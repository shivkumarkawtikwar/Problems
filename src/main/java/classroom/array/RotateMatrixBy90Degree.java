package classroom.array;

public class RotateMatrixBy90Degree {

    public void rotate(int[][] matrix) {

        reverseTD(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }

    private void reverseTD(int[][] matrix) {

        for (int i=0; i<matrix[0].length; i++) {
            int j=0;
            int k=matrix.length-1;
            while (j<k) {
                int t = matrix[j][i];
                matrix[j][i] = matrix[k][i];
                matrix[k][i] = t;
                j++;
                k--;
            }
        }
    }



    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        RotateMatrixBy90Degree r = new RotateMatrixBy90Degree();

        System.out.println("Original Matrix");
        printMatrix(matrix);
        r.rotate(matrix);

        System.out.println("Rotated Matrix");
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
