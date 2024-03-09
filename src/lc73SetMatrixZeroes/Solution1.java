package lc73SetMatrixZeroes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {

    public static void main(String[] args) {

        setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
        setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});

    }

    /*
    Time Complexity:

O(mn), where m is the number of rows and n is the number of columns in the matrix.

The nested for loops iterate through all elements of the matrix, taking O(mn) time.
The remaining loops for setting elements to zero also iterate through rows or columns,
 but their total iterations remain within a constant factor of mn.
Space Complexity:

O(m + n), considering the worst-case scenario where all rows and columns might need to be stored
in the sets.

The rowSet and columnSet use space proportional to the number of rows and columns, respectively.
Other variables like rowLength, columnLength, val, i, j, col, and row occupy constant space.
Explanation:

The nested for loops traverse every element in the matrix, leading to O(mn) time complexity.
The sets are used to efficiently track which rows and columns need to be zeroed out, but their size
is bounded by the number of rows and columns, not significantly affecting the overall time complexity.
The space complexity is dominated by the sets, which can potentially store all row and column indices
in the worst case.

Key Points:

The method prioritizes time efficiency by using sets for tracking zero rows and columns, avoiding re-scanning
the entire matrix multiple times.
It uses extra space to store this information, resulting in space complexity of O(m + n).
If space is a strict constraint, alternative approaches can be explored, potentially sacrificing some time complexity.
     */
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
