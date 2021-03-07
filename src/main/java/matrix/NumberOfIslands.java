package matrix;

/**
 * Island Count
 * Given a 2D array binaryMatrix of 0s and 1s, implement a function getNumberOfIslands that returns the number of islands of 1s in binaryMatrix.
 *
 * An island is defined as a group of adjacent values that are all 1s. A cell in binaryMatrix is considered adjacent to another cell if they are next to each either on the same row or column. Note that two values of 1 are not part of the same island if they’re sharing only a mutual “corner” (i.e. they are diagonally neighbors).
 *
 * Explain and code the most efficient solution possible and analyze its time and space complexities.
 *
 * Example:
 *
 * input:  binaryMatrix = [ [0,    1,    0,    1,    0],
 *                          [0,    0,    1,    1,    1],
 *                          [1,    0,    0,    1,    0],
 *                          [0,    1,    1,    0,    0],
 *                          [1,    0,    1,    0,    1] ]
 *
 * output: 6 # since this is the number of islands in binaryMatrix.
 *           # See all 6 islands color-coded below.
 * alt
 *
 * Constraints:
 *
 * [time limit] 5000ms
 *
 * [input] array.array.int binaryMatrix
 *
 * 1 ≤ binaryMatrix.length ≤ 100
 * 1 ≤ binaryMatrix[i].length ≤ 100
 * [output] integer
 */

class NumberOfIslands {

    static int getNumberOfIslands(int[][] binaryMatrix) {
        // your code goes here
        int cnt =100;


        for(int i=0; i<binaryMatrix.length; i++) {
            for(int j=0; j<binaryMatrix[0].length; j++) {
                if(binaryMatrix[i][j] == 1) {
                    mark(binaryMatrix, ++cnt, i, j);
                }
            }
        }

        return cnt - 100;
    }

    static void mark(int[][] t, int cnt, int i, int j) {
        if(i >= t.length || i < 0)
            return;

        if(j >= t[0].length || j<0) {
            return;
        }

        if(t[i][j] == 1) {
            t[i][j] = cnt;
            mark(t, cnt, i, j+1);
            mark(t, cnt, i, j-1);
            mark(t, cnt, i+1, j);
            mark(t, cnt, i-1, j);
        }
    }

    public static void main(String[] args) {
        int[][] t =
                {   {0,    1,    0,    1,    0},
                    {0,    0,    1,    1,    1},
                    {1,    0,    0,    1,    0},
                    {0,    1,    1,    0,    0},
                    {1,    0,    1,    0,    1}
                };
        int cnt = getNumberOfIslands(t);
        System.out.println(cnt);
        //this should be 6
    }

}
