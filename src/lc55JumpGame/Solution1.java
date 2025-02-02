package lc55JumpGame;

import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    private static boolean canJump(int[] nums) {
        Map<Integer, List<Integer>> pathMap = getPathMap(nums);
        System.out.println(pathMap);

        Deque<Integer> stack = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(0);
        while(!stack.isEmpty()){
            int curr = stack.pop();
            if(curr == nums.length -1){
                return true;
            }
            if(!visited.contains(curr)){
                System.out.print(curr + " ");
                visited.add(curr);
                for(int num : pathMap.getOrDefault(curr, new ArrayList<>())){
                    if(!visited.contains(num)){
                        stack.push(num);
                    }
                }
            }
        }
        System.out.println();
        return false;
    }

    private static Map<Integer, List<Integer>> getPathMap(int[] nums){
        List<List<Integer>> pathMap = new ArrayList<>();
        Map<Integer, List<Integer>> pathMaps = new HashMap<>();

        for (int i = 0; i < nums.length-1; i++) {
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
