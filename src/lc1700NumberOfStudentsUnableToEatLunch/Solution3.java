package lc1700NumberOfStudentsUnableToEatLunch;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    public static void main(String[] args) {

        System.out.println(countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
        System.out.println(countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }

    private static int countStudents(int[] students, int[] sandwiches) {
        int notServedStudents = 0;
        int circleStudentCount = 0;
        int squareStudentCount = 0;

        // Count the number of students who want each type of sandwich
        for (int student : students) {
            if (student == 0) {
                circleStudentCount++;
            } else {
                squareStudentCount++;
            }
        }

        // Serve sandwiches to students
        for (int sandwich : sandwiches) {
            // No student wants the circle sandwich on top of the stack
            if (sandwich == 0 && circleStudentCount == 0) {
                notServedStudents = squareStudentCount;
            }
            // No student wants the square sandwich on top of the stack
            if (sandwich == 1 && squareStudentCount == 0) {
                notServedStudents =  circleStudentCount;
            }
            // Decrement the count of the served sandwich type
            if (sandwich == 0) {
                circleStudentCount--;
            } else {
                squareStudentCount--;
            }
        }
        // Every student received a sandwich
        return notServedStudents;
    }
}
