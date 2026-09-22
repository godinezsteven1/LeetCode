class Solution {
    public int[] searchRange(int[] nums, int target) {
        /**
        
        constraints:
            non decreasiing array 
            O(log n)

        naive: O(n)
            nums = [5,7,7,8,8,10], target = 8
            int left = -1 
            for (right < nums.lenght) 
            if we see 8 for the first time  if left is -1 
            left most index at this occurance 
            right: every tme we see an 8 now we set taht index to right 
        optimal solution: 
            O(log n) -> bs 
            nums = [5,7,7,8,8,10], target = 8
            bs finds left most 
            bs finds right most 
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
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                answer = mid;
                right = mid - 1;
            }
            if (nums[mid] > target) {
                // 10 > 5
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
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                answer = mid;
                left = mid + 1;
            }
            if (nums[mid] > target) {
                // 10 > 5
                right = mid - 1;
            }
            if (nums[mid] < target) {
                // 5 < 10 
                left = mid + 1;
            }
        }
        return answer;
    }
}