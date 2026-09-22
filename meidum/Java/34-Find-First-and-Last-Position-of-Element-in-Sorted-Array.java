class Solution {
    public int[] searchRange(int[] nums, int target) {
        /**
        constraints: non decreasing array, O(log n) runtime complexity;

        naive: 
            Input: nums = [5,7,7,8,8,10], target = 8. // O (n)
            Output: [3,4]   

            for loop + 2 pointer   left = ith left  right. = pointer i if nums[right] == target 
        
        optimal:
            binary search. O(log n)
            left most binary search  [5,7,7,8,8,10] return index left
            right most binary search  [5,8 ,8,8, ,10] return index right 
        */

        int left = leftBinarySearch(nums, target);
        int right = rightBinarySearch(nums, target);

        return new int[] {left, right};
    }

    private int leftBinarySearch(int[] nums, int target) {
        int answer = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                answer = mid;
                right = mid - 1;
            }
            if (nums[mid] > target) {
                // 10 < 5
                right = mid - 1;
            }
            if (nums[mid] < target) {
                // 5 < 10 
                left = mid + 1;
            }
        }
        return answer;
    }

    private int rightBinarySearch(int[] nums, int target) {
        int answer = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                answer = mid;
                left = mid + 1;
            }
            if (nums[mid] < target) {
                // 10 < 20
                left = mid + 1;
            }
            if (nums[mid] > target) {
                // 10 > 5 
                right = mid - 1;
            }
        }
        return answer;
    }
}