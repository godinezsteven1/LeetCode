class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int curr = 0;
        int complement = 0;
        for (int i = 0; i < nums.length; i++) {
            curr = nums[i];
            complement = target - curr;
            if (map.containsKey(complement)
            && map.get(complement) != i) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {0,0};
    }
}