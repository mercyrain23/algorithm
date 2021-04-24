import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                          {5, 6, 7, 8},
                          {9,10, 11, 12}};
        System.out.println(spiralOrder(matrix));
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if(matrix == null || matrix.length == 0) {
            return result;
        }

        int rowStart = 0;
        int rowEnd = matrix.length -1; // 3 - 1
        int colStart = 0;
        int colEnd = matrix[0].length -1; // 4 - 1

        while(rowStart <= rowEnd && colStart <= colEnd) {
            // right
            for(int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

            // down
            for(int j = rowStart; j <= rowEnd; j++) {
                result.add(matrix[j][colEnd]);
            }
            colEnd--;

            // left
            if(rowStart <= rowEnd) {
                for(int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            // up
            if(colStart <= colEnd) {
                for(int j = rowEnd; j >= rowStart; j--) {
                    result.add(matrix[j][colStart]);
                }
            }
            colStart++;
        }
        return result;
    }


}
