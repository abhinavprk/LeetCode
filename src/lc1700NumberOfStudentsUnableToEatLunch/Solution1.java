package lc1700NumberOfStudentsUnableToEatLunch;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    public static void main(String[] args) {

        System.out.println(countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
        System.out.println(countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }
    /*
    Space Complexity:

    Queues stu and san: O(max(n, n)) = O(n), where n represents the larger of students.length and sandwiches.length.
    Time Complexity:

    Initialization (for loops): O(n + n) = O(n).
    While loop:
    In the worst case (no students get preferred sandwiches), the loop iterates O(n) times (all students keep cycling back).
    Operations within the loop: All operations have constant time complexity (O(1)) and are dominated by the loop iterations.
    Overall time complexity: O(n) (loop iterations) + O(n) (potential worst-case stu.offer operations) = O(n).
    Reasoning:

    In the worst case, stu.offer might be called O(n) times (once per student potentially), but each call takes constant time on average (amortized constant time).
    Therefore, the overall time complexity is still dominated by the loop iterations, which are O(n) in the worst case.
    Summary:

    Space complexity: O(n)
    Time complexity: O(n)
    */
    private static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> stu = new LinkedList<>();
        Queue<Integer> san = new LinkedList<>();
        for (int student : students) {
            stu.offer(student);
        }
        for (int sandwich : sandwiches) {
            san.offer(sandwich);
        }
        while ((!stu.isEmpty()) && (stu.contains(san.peek()))) {
            if (stu.peek().equals(san.peek())) {
                stu.poll();
                san.poll();
            } else {
                int val = stu.poll();
                stu.offer(val);
            }
        }
        return stu.size();
    }
}
