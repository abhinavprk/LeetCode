package lc2029FindPeopleWithSecrets;

import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        int n = 6;
        int[][] meetings = {{0, 2, 1}, {1, 3, 1}, {4, 5, 1}};
        int firstPerson = 1;
        System.out.println(findAllPeople(n, meetings, firstPerson));
    }

    private static List<Integer> findAllPeople(int totalNoOfPeople, int[][] meetings, int firstPerson) {
        // For every person, we store the meeting time and label of the person met.
        Map<Integer, List<int[]>> personToListOfPeopleAndTime = new HashMap<>();
        for (int[] meeting : meetings) {
            int participantOne = meeting[0], participantTwo = meeting[1], timeOfMeeting = meeting[2];
            personToListOfPeopleAndTime.computeIfAbsent(participantOne, k -> new ArrayList<>()).add(new int[]{participantTwo, timeOfMeeting});
            personToListOfPeopleAndTime.computeIfAbsent(participantTwo, k -> new ArrayList<>()).add(new int[]{participantOne, timeOfMeeting});
        }

        // Earliest time at which a person learned the secret
        // as per current state of knowledge. If due to some new information,
        // the earliestTimeAtWhichSecretWasIdentified time of knowing the secret changes, we will update it
        // and again process all the people whom he/she meets after the time
        // at which he/she learned the secret.
        int[] earliestTimeAtWhichSecretWasIdentified = new int[totalNoOfPeople];
        Arrays.fill(earliestTimeAtWhichSecretWasIdentified, Integer.MAX_VALUE);
        //At time 0 secret was known to person 0, and he told this to firstPerson
        earliestTimeAtWhichSecretWasIdentified[0] = 0;
        earliestTimeAtWhichSecretWasIdentified[firstPerson] = 0;

        // Queue for Graph Representation and BFS. It will store (person, time of knowing the secret)
        Queue<int[]> personAndEarliestTime = new LinkedList<>();
        personAndEarliestTime.offer(new int[]{0, 0});
        personAndEarliestTime.offer(new int[]{firstPerson, 0});

        // Do BFS
        //Until all the nodes are visited
        while (!personAndEarliestTime.isEmpty()) {
            //Get the first node (head of the Queue)
            int[] personTime = personAndEarliestTime.poll();
            int personWithSecret = personTime[0];
            int timeOfKnowledge = personTime[1];
            //Get the list of the array of (participant, meetingTime) from the map created earlier, and
            //traverse through it.
            for (int[] nextPersonTime : personToListOfPeopleAndTime.getOrDefault(personWithSecret, new ArrayList<>())) {
                //For every meeting, verify if this meeting happened after the personWithSecret found the secret.
                int nextPerson = nextPersonTime[0];
                int timeOfMeeting = nextPersonTime[1];
                if (timeOfMeeting >= timeOfKnowledge && earliestTimeAtWhichSecretWasIdentified[nextPerson] > timeOfMeeting) {
                    //Time of meeting is after or same as time of knowledge by personWithSecret.
                    //nextPerson will also find out the secret
                    earliestTimeAtWhichSecretWasIdentified[nextPerson] = timeOfMeeting;
                    //Add nextPerson with his time to the Queue (Graph)
                    personAndEarliestTime.offer(new int[]{nextPerson, timeOfMeeting});
                }
            }
        }

        // Since we visited only those people who know the secret,
        // we need to return indices of all visited people.
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < totalNoOfPeople; ++i) {
            if (earliestTimeAtWhichSecretWasIdentified[i] != Integer.MAX_VALUE) {
                ans.add(i);
            }
        }
        return ans;
    }
}
