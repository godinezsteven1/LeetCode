class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = leftMostBinaryBound(nums, target);
        int right = rightMostBinaryBound(nums, target);
        return new int[] {left, right};
    }

    private int leftMostBinaryBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                answer = mid;
                right = mid - 1;
            } else
            if (nums[mid] < target) {
                left = mid + 1;
            } else
            if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return answer;
    }

    private int rightMostBinaryBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                answer = mid;
                left = mid + 1;
            } else
            if (nums[mid] < target) {
                left = mid + 1;
            } else
            if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return answer;
    }
}