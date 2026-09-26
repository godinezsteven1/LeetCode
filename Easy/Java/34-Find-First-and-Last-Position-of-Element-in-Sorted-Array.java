class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = leftBinarySearch(nums, target);
        int right = rightBinarySearch(nums, target);
        return new int[] {left, right};
    }

    private int leftBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = (right + left) / 2;
            int curr = nums[mid];
            if (curr == target) {
                answer = mid;
                right = mid - 1;
            }
            if (curr < target) {
                left = mid + 1;
            }
            if (curr > target) {
                right = mid - 1;
            }
        }

        return answer;
    }

    private int rightBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = (right + left) / 2;
            int curr = nums[mid];
            if (curr == target) {
                answer = mid;
                left = mid + 1;
            }
            if (curr < target) {
                left = mid + 1;
            }
            if (curr > target) {
                right = mid - 1;
            }
        }

        return answer;
    }
}