package lc253MeetingRoomsII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{{0,30},{5,10},{15, 20}}));

        System.out.println(minMeetingRooms(new int[][]{{7,10},{2,4},{15, 20}}));
    }

    /*
    Time Complexity:

    O(n log n)
    Sorting the intervals array using Arrays.sort with a custom comparator takes
    O(n log n) time in the worst case due to comparison-based sorting algorithms like quicksort or
    merge sort being used internally.

    Space Complexity:

    O(n)
    The method utilizes a PriorityQueue named busyUntil to store the end times of currently occupied meeting rooms. In the worst case, all meetings might be happening concurrently, leading to a maximum size of n elements in the priority queue.
    Explanation:

    Sorting: The initial sorting of intervals based on start times dominates the time complexity because it involves iterating and comparing elements in the array, leading to a logarithmic factor based on the input size n.
    Priority Queue: The PriorityQueue provides efficient retrieval of the earliest ending meeting, contributing to the overall efficiency. However, its size scales with the number of concurrent meetings (n in the worst case).
    Constant Time Operations: Most other operations within the loop (comparisons, adding/removing elements to the queue) are constant time.
    Overall:

    While the priority queue contributes some space overhead, the sorting step dominates the overall time complexity. This approach offers a good balance between time and space efficiency for finding the minimum number of meeting rooms required.
     */
    private static int minMeetingRooms(int[][] intervals) {
        // Sort meetings according to start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // We need one room at least
        int roomCount = 1;
        // This will store the end time of the currently busy rooms. With the lowest end
        // time at top
        PriorityQueue<Integer> busyUntil = new PriorityQueue<>();
        for (int[] meeting : intervals) {
            int str = meeting[0];
            int end = meeting[1];
            // If there are busy rooms, we check if the meeting ending first ends before the
            // start of this meeting
            if (!busyUntil.isEmpty() && busyUntil.peek() > str) {
                // if not we need a new room
                roomCount++;
            } else {
                // if yes, we can use one of the rooms. Remove the end time for the meeting that
                // is replaced with the
                // current meeting
                busyUntil.poll();
            }
            // Update the end time of the current meeting in the end time queue for further
            // processing
            busyUntil.offer(end);
        }
        return roomCount;
    }
}
