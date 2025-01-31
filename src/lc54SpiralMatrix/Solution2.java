package lc54SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0;
        int left = 0;
        int bottom = rows - 1;
        int right = cols - 1;
        int expectedResultSize = rows * cols;
        while (result.size() < expectedResultSize) {
            // Traverse from left to right
            for (int i = left; i <= right && result.size() < expectedResultSize; i++)
                result.add(matrix[top][i]);
            top++;

            // Traverse from top to bottom
            for (int i = top; i <= bottom && result.size() < expectedResultSize; i++)
                result.add(matrix[i][right]);
            right--;

            // Traverse from right to left
            for (int i = right; i >= left && result.size() < expectedResultSize; i--)
                result.add(matrix[bottom][i]);
            bottom--;

            // Traverse from bottom to top
            for (int i = bottom; i >= top && result.size() < expectedResultSize; i--)
                result.add(matrix[i][left]);
            left++;
        }

        return result;
    }
}
