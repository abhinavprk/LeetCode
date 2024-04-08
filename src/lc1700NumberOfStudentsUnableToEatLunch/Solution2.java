package lc1700NumberOfStudentsUnableToEatLunch;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {

        System.out.println(countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
        System.out.println(countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }
    private static int countStudents(int[] students, int[] sandwiches) {
        int len = students.length; // Sandwiches will be the same length
        Queue<Integer> studentQueue = new LinkedList<>();
        Stack<Integer> sandwichStack = new Stack<>();

        // Add students and sandwiches to the queue and stack
        for (int i = 0; i < len; i++) {
            sandwichStack.push(sandwiches[len - i - 1]);
            studentQueue.offer(students[i]);
        }

        // Simulate the lunch process by serving sandwiches
        // or sending students to the back of the queue.
        int lastServed = 0;
        while (!studentQueue.isEmpty() && lastServed < studentQueue.size()) {
            if (Objects.equals(sandwichStack.peek(), studentQueue.peek())) {
                sandwichStack.pop(); // Serve sandwich
                studentQueue.poll(); // Student leaves queue
                lastServed = 0;
            } else {
                // Student moves to back of queue
                studentQueue.offer(studentQueue.poll());
                lastServed++; //If this becomes equal to the size of the student queue, this
                // means that every student in the queue was offered the sandwich but they didn't
                // take it.  this is an extra loop that I don't like. Solution 1 is handling it
                // better
            }
        }

        // Remaining students in queue are unserved students
        return studentQueue.size();
    }
}
