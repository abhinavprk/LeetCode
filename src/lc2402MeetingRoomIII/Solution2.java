package lc2402MeetingRoomIII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/meeting-rooms-iii/description/
 */
public class Solution2 {

    public static void main(String[] args) {
        int noOfRooms = 2;
        int [][] meetings = {{0,10},{1,5},{2,7},{3,4}};
        System.out.println(mostBooked(noOfRooms, meetings));
    }

    private static int mostBooked(int n, int[][] meetings) {
        var meetingCount = new int[n];
        //The usedRooms priorityQue contains long[] with two values each, end of the meeting, and the room.
        // It is ordered by first by the end time and then by the room index.
        var usedRooms = new PriorityQueue<long[]>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        //The unusedRooms priorityQueue contains the room indexes
        var unusedRooms = new PriorityQueue<Integer>();
        //Prepare the unusedRooms
        for (int i = 0; i < n; i++) {
            unusedRooms.offer(i);
        }
        //sort the meetings first by start time and then by end times
        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        //Traverse the meetings
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            //fill up unusedRooms for current meeting. All the rooms for which end is before the start of the current meeting
            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                int room = (int) usedRooms.poll()[1];
                unusedRooms.offer(room);
            }

            if (!unusedRooms.isEmpty()) {
                //If unused rooms are available
                int room = unusedRooms.poll();
                usedRooms.offer(new long[]{end, room});
                meetingCount[room]++;
            } else if(!usedRooms.isEmpty()){
                //else if used rooms is not empty, pick the room for which the meeting is ending first and update for the current meeting
                long roomAvailabilityTime = usedRooms.peek()[0];
                int room = (int) usedRooms.poll()[1];
                usedRooms.offer(new long[]{roomAvailabilityTime + end - start, room});
                meetingCount[room]++;
            }
        }

        int maxMeetingCount = 0;
        int maxMeetingCountRoom = 0;
        //find the room with maximum meetings
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > maxMeetingCount) {
                maxMeetingCount = meetingCount[i];
                maxMeetingCountRoom = i;
            }
        }

        return maxMeetingCountRoom;
    }
}