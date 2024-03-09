package lc73SetMatrixZeroes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {

    public static void main(String[] args) {

        setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
        setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});

    }

    private static void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }
        for (int val : rowSet) {
            int col = 0;
            while (col < columnLength) {
                matrix[val][col] = 0;
                col++;
            }
        }
        for (int val : columnSet) {
            int row = 0;
            while (row < rowLength) {
                matrix[row][val] = 0;
                row++;
            }
        }
        for(int[] val: matrix) {
            System.out.println(Arrays.toString(val));
        }
    }
}
