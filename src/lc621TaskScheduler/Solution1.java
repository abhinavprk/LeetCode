package lc621TaskScheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A','A','A', 'B','B','B'}, 2));
        System.out.println(leastInterval(new char[]{'A','A','A', 'B','B','B'}, 3));
        System.out.println(leastInterval(new char[]{'A','C','A', 'B','D','B'}, 1));
    }
    private static int leastInterval(char[] tasks, int n) {

        int [] frequencies = new int[26];

        for (char val: tasks){
            frequencies[val-'A'] += 1;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : frequencies){
            if (val > 0){
                priorityQueue.offer(val);
            }
        }
        int interval = 0;
        while (!priorityQueue.isEmpty()){
            List<Integer> remaining = new ArrayList<>();
            int cycle = n + 1;
            int taskCount = 0;
            while (cycle > 0 && !priorityQueue.isEmpty()) {
                cycle--;
                int curr = priorityQueue.poll();
                if(curr > 1){
                    remaining.add(--curr);
                }
                taskCount++;
            }
            remaining.forEach(priorityQueue::offer);
            interval = interval + (priorityQueue.isEmpty()?taskCount: n+1);
        }

        return interval;
    }


}
