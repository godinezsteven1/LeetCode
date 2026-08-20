class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0; 

        while (left != right) {
            int width = right - left;
            if (height[left] < height[right]) {
                max = Math.max(height[left] * width, max);
                left++;
            } else
            if (height[left] > height[right]) {
                max = Math.max(height[right] * width, max);
                right--;
            } else
            if (height[left] == height[right]) {
                max = Math.max(height[left] * width, max);
                left++;
            }
        }
        return max; 
    }
}