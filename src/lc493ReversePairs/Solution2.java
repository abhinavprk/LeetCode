package lc493ReversePairs;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{1, 3, 2, 3, 1}));
        System.out.println(reversePairs(new int[]{2, 4, 3, 5, 1}));
        System.out.println(reversePairs(new int[]{2}));
        System.out.println(reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
    }

    public static int reversePairs(int[] nums) {
        return mergeShort(nums, 0, nums.length - 1);
    }

    private static int mergeShort(int[] nums, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count = count + mergeShort(nums, low, mid);
            count = count + mergeShort(nums, low + 1, high);
            count = count + countPairs(nums, low, high, mid);
            merge(nums, low, high, mid);
        }
        return count;
    }

    private static int countPairs(int[] nums, int low, int high, int mid) {
        int count = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            long val1 = nums[i];

            while ((right <= high) && (val1 > (2*(long)nums[right]))) {
                    right++;
            }
            count = count + (right - (mid + 1));
        }


        return count;
    }

    private static void merge(int[] nums, int low, int high, int mid) {
        int left = low;
        int right = mid + 1;
        int[] temp = new int[high - low + 1];
        int tempIndex = 0;

        while ((left <= mid) && (right <= high)) {
            if (nums[left] <= nums[right]) {
                temp[tempIndex++] = nums[left];
                left++;
            } else {
                temp[tempIndex++] = nums[right];
                right++;
            }
        }

        while (left <= mid) {
            temp[tempIndex++] = nums[left];
            left++;
        }

        while (right <= high) {
            temp[tempIndex++] = nums[right];
            right++;
        }

        System.arraycopy(temp, 0, nums, low, temp.length);
    }
}
