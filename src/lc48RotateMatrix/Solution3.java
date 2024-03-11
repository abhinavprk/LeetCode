package lc48RotateMatrix;

public class Solution3 {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(matrix);
        rotate(matrix);
        printMatrix(matrix);

        int[][] myMatrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        printMatrix(myMatrix);
        rotate(myMatrix);
        printMatrix(myMatrix);


    }

    /*
        1 2 3
        4 5 6
        7 8 9

        7 4 1
        8 5 2
        9 6 3
    */

    private static void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int col = 0; col < (len + 1) / 2; col++) {
            for (int row = 0; row < len / 2; row++) {

                int temp = matrix[len - 1 - row][col]; //(2,0)

                //(2,0)                             //(2,2)
                matrix[len - 1 - row][col] = matrix[len - 1 - col][len - row - 1];

                //(2,2)                                //(0,2)
                matrix[len - 1 - col][len - row - 1] = matrix[row][len - 1 - col];

                //(0,2)                      //(0,0)
                matrix[row][len - 1 - col] = matrix[col][row];

                //(0,0)
                matrix[col][row] = temp;
            }
        }
    }

    private static void printMatrix(int[][] myMatrix) {
        for (int[] val : myMatrix) {
            for (int num : val) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
