class Solution {
    public int trap(int[] height) {
        int left = 0; 
        int leftMax = 0; 
        int right = height.length - 1;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                // left bottleneck increase
                water += leftMax - height[left];
                left++;
            } else {
                // left bottleneck increase
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}