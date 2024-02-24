package lc2029FindPeopleWithSecrets;

import java.util.*;

public class Solution3 {

    public static void main(String[] args) {
        int n = 6;
        int[][] meetings = {{0,2,1},{1,3,1},{4,5,1}};
        int firstPerson = 1;
        System.out.println(findAllPeople(n, meetings, firstPerson));
    }

    private static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // For every person, we store the meeting time and label of the person met.
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] meeting : meetings) {
            int x = meeting[0], y = meeting[1], t = meeting[2];
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[]{t, y});
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(new int[]{t, x});
        }

        // Earliest time at which a person learned the secret
        // as per current state of knowledge. If due to some new information,
        // the earliest time of knowing the secret changes, we will update it
        // and again process all the people whom he/she meets after the time
        // at which he/she learned the secret.
        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);
        earliest[0] = 0;
        earliest[firstPerson] = 0;

        // Do DFS
        dfs(0, 0, graph, earliest);
        dfs(firstPerson, 0, graph, earliest);

        // Since we visited only those people who know the secret
        // we need to return indices of all visited people.
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (earliest[i] != Integer.MAX_VALUE) {
                ans.add(i);
            }
        }
        return ans;
    }

    private static void dfs(int person, int time, Map<Integer, List<int[]>> graph, int[] earliest) {
        for (int[] nextPersonTime : graph.getOrDefault(person, new ArrayList<>())) {
            int t = nextPersonTime[0], nextPerson = nextPersonTime[1];
            if (t >= time && earliest[nextPerson] > t) {
                earliest[nextPerson] = t;
                dfs(nextPerson, t, graph, earliest);
            }
        }
    }
}
