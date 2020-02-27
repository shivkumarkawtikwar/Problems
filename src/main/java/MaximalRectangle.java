import java.util.*;

class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int nr = matrix.length;
        int nc = matrix[0].length;

        int[][] noOfOne = new int[nr][nc];
        initNoOfOne(matrix, nr, nc, noOfOne);

        int maxArea = 0;

        for (int i=0; i < nr; i++) {
            for (int j =0; j < nc; j++) {
                int area =0;
                if (matrix[i][j] == '1') {
                    int rowS = noOfOne[i][j];
                    for (int k = i; k >=0; k--) {
                        if (matrix[k][j] == '0')
                            break;
                        else {
                            rowS = Math.min(rowS, noOfOne[k][j]);
                            area = Math.max(area, rowS * (i-k+1));
                        }
                    }
                }
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public void initNoOfOne(char[][] matrix, int nr, int nc, int[][] noOfOne) {
        int cnt = 0;
        for (int i=0; i < nr; i++) {
            cnt = 0;
            for (int j=0; j< nc; j++) {
                if (matrix[i][j] == '0')
                    cnt = 0;
                else
                    cnt++;
                noOfOne[i][j] = cnt;
            }
        }
    }

    class Area {
        int r=0;
        int c=0;
        int area;

        public Area(int r, int c) {
            this.r = r;
            this.c = c;
            area = this.r * this.c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Area area = (Area) o;
            return r == area.r &&
                    c == area.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

}