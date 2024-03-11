package lc48RotateMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        printMatrix(matrix);
        rotate(matrix);
        printMatrix(matrix);

        int[][] myMatrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        printMatrix(myMatrix);
        rotate(myMatrix);
        printMatrix(myMatrix);


    }
    private static void rotate(int[][] matrix) {
        int length = matrix.length;
        List<List<Integer>> visited = new ArrayList<>();
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                int cRow = row;
                int cCol = col;
                int curr = matrix[cRow][cCol];
                    do {
                        List<Integer> current = new ArrayList<>();
                        current.add(cRow);
                        current.add(cCol);
                        if (!visited.contains(current)) {
                            visited.add(current);
                            int nRow = cCol;
                            int nCol = (length - 1 - cRow);
                            int toBeReplaced = matrix[nRow][nCol];
                            matrix[nRow][nCol] = curr;
                            curr = toBeReplaced;
                            cRow = nRow;
                            cCol = nCol;
                        }
                    } while ((cRow != row) || (cCol != col));
            }
        }
    }

    private static void printMatrix(int[][] myMatrix) {
        for(int[] val: myMatrix){
            for(int num: val){
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
