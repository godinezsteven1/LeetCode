class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer> hashMap = new HashMap<>(n); 
        for (int i = 0; i < n; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            int current = nums[i];
            int complement = target - current; 
            if (hashMap.containsKey(complement) 
                && hashMap.get(complement) != i) { // avoid dup
                int idx = hashMap.get(complement);
                int[] answer = {i, idx};
                return answer; 
            }
        }
        return new int[]{}; 
    }
}