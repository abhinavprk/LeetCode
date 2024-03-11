package lc48RotateMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {

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
    /*
    The provided method has the following time and space complexity:

    Time Complexity: O(n^2)
    Space Complexity: O(n^2)
    Here's a breakdown of why:

    Time Complexity:

    The outer for loops iterate length times each, resulting in a total of length * length iterations (roughly equivalent to n^2).
    Within the inner loop, the do-while loop keeps iterating until the current position reaches the starting position. In the worst
    case scenario, this loop could iterate for all elements in the matrix, contributing to the n^2 complexity.
    Space Complexity:

    The visited list stores indices of visited elements. In the worst case, it can store all elements from the matrix, leading to a
    space complexity of O(n^2). This is because every element might be visited if it's part of a cycle.
     */
    private static void rotate(int[][] matrix) {
        int length = matrix.length;
        List<List<Integer>> visited = new ArrayList<>();
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                int cRow = row;
                int cCol = col;
                int curr = matrix[cRow][cCol];
                List<Integer> currentIndex = new ArrayList<>();
                currentIndex.add(row);
                currentIndex.add(col);
                if (!visited.contains(currentIndex)) {
                    do {
                        List<Integer> current = new ArrayList<>();
                        current.add(cRow);
                        current.add(cCol);
                        visited.add(current);
                        int nRow = cCol;
                        int nCol = (length - 1 - cRow);
                        int toBeReplaced = matrix[nRow][nCol];
                        matrix[nRow][nCol] = curr;
                        curr = toBeReplaced;
                        cRow = nRow;
                        cCol = nCol;
                    } while ((cRow != row) || (cCol != col));
                }
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
