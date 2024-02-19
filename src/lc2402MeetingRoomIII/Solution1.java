package lc2402MeetingRoomIII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/meeting-rooms-iii/description/
 */
public class Solution1 {
    public static void main(String[] args) {
        int noOfRooms = 2;
        int [][] meetings = {{0,10},{1,5},{2,7},{3,4}};
        System.out.println(mostBooked(noOfRooms, meetings));
    }

    private static int mostBooked(int noOfRooms, int[][] meetings) {
        //Sort the meetings with startTime
        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        long [] roomAvailabilityTime = new long [noOfRooms];
        int [] meetingCount = new int [noOfRooms];
        for (int[] meeting : meetings) {
            //Iterate through the meetings
            int startTime = meeting[0];
            int endTime = meeting[1];
            boolean meetingAssigned = false; //If the meeting is assigned or not
            for (int room = 0; room < roomAvailabilityTime.length; room++) {
                //Iterate through the rooms for their availability
                long availableFrom = roomAvailabilityTime[room];
                if (availableFrom <= startTime) {
                    //This room is available to be occupied by this meeting
                    //Update the availability time
                    roomAvailabilityTime[room] = endTime;
                    //Increase the meeting count
                    meetingCount[room]++;
                    meetingAssigned = true;
                    break;
                }
            }
            //If meeting is not assigned that means no room is free
            //Find the next available room with the lowest index
            if (!meetingAssigned) {
                int nextAvailableRoom = -1;
                long nextAvailabilityFrom = Long.MAX_VALUE;
                for (int room = 0; room < roomAvailabilityTime.length; room++) {
                    //Iterate through the rooms for their availability
                    long availableFrom = roomAvailabilityTime[room];
                    if (availableFrom < nextAvailabilityFrom) {
                        //This will be the room with the lower index even in the case of two rooms have the same
                        //availability time
                        nextAvailableRoom = room;
                        nextAvailabilityFrom = availableFrom;
                    }
                }
                meetingCount[nextAvailableRoom]++;
                roomAvailabilityTime[nextAvailableRoom] = nextAvailabilityFrom + (endTime - startTime);
            }
        }
        //Find the meeting room with maximum meetings
        int maximumCount = -1;
        int lowestIndexForMaximumCount = Integer.MAX_VALUE;
        for (int room = 0; room < meetingCount.length; room++) {
            int count = meetingCount[room];
            //This will choose the meeting room with the highest meetings but that is of lowest index
            if(count > maximumCount){
                maximumCount = count;
                lowestIndexForMaximumCount = room;
            }
        }
        return lowestIndexForMaximumCount;
    }
}
