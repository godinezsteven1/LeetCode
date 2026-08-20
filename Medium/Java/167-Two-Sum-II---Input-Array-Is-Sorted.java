class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length - 1; 
        int left = 0; 

        while (left < right) {
            int sum = numbers[right] + numbers[left];
            if (sum > target) {
                right--;
            } else
            if (sum < target) {
                left++;
            } else
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            }
        }
        return new int[] {0,0};
    }
}