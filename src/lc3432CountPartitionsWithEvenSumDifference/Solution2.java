package lc3432CountPartitionsWithEvenSumDifference;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(countPartitions(new int[]{1,2,2}));
        System.out.println(countPartitions(new int[]{2,4,6,8}));
    }

    private static int countPartitions(int[] nums) {
        int totalSum = 0;
        int prefixSum = 0;
        int count = 0;

        // Step 1: Calculate total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: Iterate and count valid partitions
        for (int i = 0; i < nums.length - 1; i++) {
            prefixSum += nums[i];
            int suffixSum = totalSum - prefixSum;

            // Check if prefixSum and suffixSum have the same parity (even or odd)
            if ((prefixSum % 2) == (suffixSum % 2)) {
                count++;
            }
        }
        return count;
    }
}

// 1 2 3 4 5

// 1 3 6 10 15

// 15
// 15 14 12 9 5
