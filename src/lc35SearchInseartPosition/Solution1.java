package lc35SearchInseartPosition;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

    private static int searchInsert(int[] nums, int target) {
        int result = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target) {
                result = mid;
                break;
            } else if (nums[mid] > target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if ((result == -1) && (nums[nums.length - 1] <= target)) {
            result = nums.length - 1;
        }
        return result;
    }
}
