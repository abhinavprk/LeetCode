package lc55JumpGame;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
      System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
      System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
      System.out.println(canJump(new int[]{2, 0, 0}));
    }
    //TLE in leetcode
    private static boolean canJump(int[] nums) {
        Map<Integer, List<Integer>> pathMap = getPathMap(nums);
        System.out.println(pathMap);
        return findIfCanJump(0, pathMap, new HashSet<>());

    }

    private static boolean findIfCanJump(int start, Map<Integer, List<Integer>> pathMap, Set<Integer> visited) {
        System.out.print(start + " ");
        if (start == pathMap.size()) {
            return true;
        } else {
            visited.add(start);
            for (int num : pathMap.getOrDefault(start, new ArrayList<>())) {
                System.out.println("numA: " + num);
                if (!visited.contains(num)) {
                    System.out.println("num: " + num);
                    if(findIfCanJump(num, pathMap, visited)){
                        return true;
                    };
                }
            }
            System.out.println();
            return false;
        }

    }

    private static Map<Integer, List<Integer>> getPathMap(int[] nums) {
        Map<Integer, List<Integer>> pathMaps = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int maxJump = nums[i];
            int possibleDestinationCount = Math.min((nums.length - i - 1), maxJump);
            List<Integer> possibleJumps = new ArrayList<>();
            for (int j = 0; j < possibleDestinationCount; j++) {
                possibleJumps.add(i + j + 1);
            }
            pathMaps.put(i, possibleJumps);
        }
        return pathMaps;
    }
}
