package lc621TaskScheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3));
        System.out.println(leastInterval(new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 1));
    }

    /*
    Space Complexity:

    frequencies array: O(26) = O(1), as it stores a fixed number of character frequencies.
    priorityQueue: O(m), where m is the number of distinct tasks, as it holds at most one entry per distinct task.
    remaining list: O(m), as it can potentially store all distinct tasks in a cycle.
    Other variables: O(1), as they occupy constant space.
    Overall space complexity: O(m), dominated by the priorityQueue and remaining list.

    Time Complexity:

    Initialization (frequencies array + priorityQueue): O(n), where n is the length of the tasks array.
    Main loop:
    Iterations: Up to tasks.length times (worst-case when all tasks have distinct frequencies).
    Operations within each iteration:
    Poll from priorityQueue: O(log m)
    Add to priorityQueue: O(log m)
    Decrement cycle: O(1)
    Add to remaining list: O(1)
    Overall time complexity: O(n * log m)

    Key points:

    The method's primary time bottleneck lies in the potential multiple cycles within the main loop.
    It's worth noting that the worst-case scenario of O(n * log m) is less likely in practice, as tasks often have repeated frequencies.
    For a more efficient solution, consider an alternative approach using a frequency map and tracking the cooldown directly, potentially achieving O(n) time complexity.
     */
    private static int leastInterval(char[] tasks, int n) {

        int[] frequencies = new int[26];

        for (char val : tasks) {
            frequencies[val - 'A'] += 1;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : frequencies) {
            if (val > 0) {
                priorityQueue.offer(val);
            }
        }
        int interval = 0;
        while (!priorityQueue.isEmpty()) {
            List<Integer> remaining = new ArrayList<>();
            int cycle = n + 1;
            int taskCount = 0;
            while (cycle > 0 && !priorityQueue.isEmpty()) {
                cycle--;
                int curr = priorityQueue.poll();
                if (curr > 1) {
                    remaining.add(--curr);
                }
                taskCount++;
            }
            remaining.forEach(priorityQueue::offer);
            interval = interval + (priorityQueue.isEmpty() ? taskCount : n + 1);
        }

        return interval;
    }


}
