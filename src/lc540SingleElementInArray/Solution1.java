package lc540SingleElementInArray;

public class Solution1 {

    public static void main(String[] args) {

        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        System.out.println(singleNonDuplicate(new int[]{1}));
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3}));
    }

    private static int singleNonDuplicate(int[] nums) {
        int result = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean isHalfEven = ((high - mid) % 2 == 0);
            if (nums[mid] == nums[mid - 1]) {
                if (isHalfEven) {
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if (isHalfEven) {
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            } else {
                result = nums[mid];
                break;
            }
        }
        if (result == -1) {
            result = nums[low];
        }
        return result;
    }

}
